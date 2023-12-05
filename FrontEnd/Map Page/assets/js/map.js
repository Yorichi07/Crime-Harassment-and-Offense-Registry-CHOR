const MAX_CASES = 40361
const MIN_CASES = 0
async function getData(){
    let data = await fetch("http://localhost:8080/api/getCoords",{
        method:"GET",
        headers:{"Content-Type":"application/json; charset=UTF-8"},
    }).then(res=>{
        return res.json()
    }).catch(err=>{
        console.log(err)
    })

    let casesNum = await fetch("http://localhost:8080/api/getCrimes",{
        method:"GET",
        headers:{"Content-Type":"application/json; charset=UTF-8"},
    }).then(res=>{
        return res.json()
    }).then(resp=>{
        let dat = new Map();

        for(i=0;i<resp.length;i++){
            if(resp[i].District === "Total") continue
            if(resp[i]) dat.set(resp[i].District.toLowerCase().split(" ").join(""),parseInt(((parseInt(resp[i].Total_IPC)-MIN_CASES)/MAX_CASES-MIN_CASES)*255))
            //dat.set(resp[i].District.lower.split(" ").join(" "))
        }
        return dat
    }).catch(err=>{
        console.log(err)
    })
    

    let mapOptions = {
            center: [17.3718,80.1541],
            zoom:6
    }
    let map = new L.map(document.querySelector(".mapCont"),mapOptions)    
    var layer = new L.TileLayer("http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png")
    map.addLayer(layer)

    let color = ["green","yellow","red"]

    for(i=0;i<data.features.length;i=i+1){
        for(j=0;j<data.features[i].geometry.coordinates.length;j=j+1){
                
            var polygon = L.polygon(data.features[i].geometry.coordinates[j][0],{
                color:`blue`,
                weight:0.5,
                fillColor:`${casesNum.get(data.features[i].properties.NAME_2.toLowerCase())?casesNum.get(data.features[i].properties.NAME_2.toLowerCase())<15?color[0]:casesNum.get(data.features[i].properties.NAME_2.toLowerCase())>50?color[2]:color[1]:color[1]}`,
                fillOpacity:0.9
            })
            map.addLayer(polygon)
        }
    }
}
getData()
function successSubmit(e) {
    window.alert("Feedback Submitted successfully!");
    location.reload();
}