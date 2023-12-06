function successSubmit(e) {
    window.alert("Feedback Submitted successfully!");
    location.reload();
}
async function LoadData(){
    let data = await fetch("http://localhost:8080/api/GetMissing",{
        method:"GET",
        headers:{"Content-Type":"application/json; charset=UTF-8"}
    }).then(res=>{
        return res.json()
    }).then(resp=>{
        return resp
    }).catch(err=>{
        console.log(err)
    })


    const wrapper = document.querySelector(".misCard_cont")

    for(i=0;i<100;i=i+1){
        let card = document.createElement("div")
        card.className = "class_23"
        let card_in = document.createElement("div")
        card_in.className = "class_24"
        card.appendChild(card_in)
        let img = document.createElement("img")
        img.src = data[i].Image?data[i].Image:"http://localhost:8080/Images/Aditya/2.png"
        img.className = "class_25"
        card_in.appendChild(img)
        let namecont = document.createElement("div")
        namecont.className = "class_26"
        let nameLabel = document.createElement("label")
        nameLabel.className = "class_27"
        nameLabel.innerHTML = "Name:"
        namecont.appendChild(nameLabel)
        let nameWrap = document.createElement("span")
        nameWrap.className = "class_28"
        nameWrap.innerHTML = data[i].Name
        namecont.appendChild(nameWrap)
        card_in.appendChild(namecont)
        namecont = document.createElement("div")
        namecont.className = "class_26"
        nameLabel = document.createElement("label")
        nameLabel.className = "class_27"
        nameLabel.innerHTML = "Gender:"
        namecont.appendChild(nameLabel)
        nameWrap = document.createElement("span")
        nameWrap.className = "class_28"
        nameWrap.innerHTML = data[i].Gender
        namecont.appendChild(nameWrap)
        card_in.appendChild(namecont)
        namecont = document.createElement("div")
        namecont.className = "class_26"
        nameLabel = document.createElement("label")
        nameLabel.className = "class_27"
        nameLabel.innerHTML = "Relative:"
        namecont.appendChild(nameLabel)
        nameWrap = document.createElement("span")
        nameWrap.className = "class_28"
        nameWrap.innerHTML = data[i].Relative
        namecont.appendChild(nameWrap)
        card_in.appendChild(namecont)
        namecont = document.createElement("div")
        namecont.className = "class_26"
        nameLabel = document.createElement("label")
        nameLabel.className = "class_27"
        nameLabel.innerHTML = "Address:"
        namecont.appendChild(nameLabel)
        nameWrap = document.createElement("span")
        nameWrap.className = "class_28"
        nameWrap.innerHTML = data[i].Address
        namecont.appendChild(nameWrap)
        card_in.appendChild(namecont)
        namecont = document.createElement("div")
        namecont.className = "class_26"
        nameLabel = document.createElement("label")
        nameLabel.className = "class_27"
        nameLabel.innerHTML = "Age:"
        namecont.appendChild(nameLabel)
        nameWrap = document.createElement("span")
        nameWrap.className = "class_28"
        nameWrap.innerHTML = data[i].Age
        namecont.appendChild(nameWrap)
        card_in.appendChild(namecont)
        namecont = document.createElement("div")
        namecont.className = "class_26"
        nameLabel = document.createElement("label")
        nameLabel.className = "class_27"
        nameLabel.innerHTML = "Height:"
        namecont.appendChild(nameLabel)
        nameWrap = document.createElement("span")
        nameWrap.className = "class_28"
        nameWrap.innerHTML = data[i].Height
        namecont.appendChild(nameWrap)
        card_in.appendChild(namecont)
        namecont = document.createElement("div")
        namecont.className = "class_26"
        nameLabel = document.createElement("label")
        nameLabel.className = "class_27"
        nameLabel.innerHTML = "Built:"
        namecont.appendChild(nameLabel)
        nameWrap = document.createElement("span")
        nameWrap.className = "class_28"
        nameWrap.innerHTML = data[i].Built
        namecont.appendChild(nameWrap)
        card_in.appendChild(namecont)
        namecont = document.createElement("div")
        namecont.className = "class_26"
        nameLabel = document.createElement("label")
        nameLabel.className = "class_27"
        nameLabel.innerHTML = "District:"
        namecont.appendChild(nameLabel)
        nameWrap = document.createElement("span")
        nameWrap.className = "class_28"
        nameWrap.innerHTML = data[i].District
        namecont.appendChild(nameWrap)
        card_in.appendChild(namecont)
        namecont = document.createElement("div")
        namecont.className = "class_26"
        nameLabel = document.createElement("label")
        nameLabel.className = "class_27"
        nameLabel.innerHTML = "State:"
        namecont.appendChild(nameLabel)
        nameWrap = document.createElement("span")
        nameWrap.className = "class_28"
        nameWrap.innerHTML = data[i].State
        namecont.appendChild(nameWrap)
        card_in.appendChild(namecont)
        card.appendChild(card_in)
        wrapper.appendChild(card)
    }

}

LoadData()

async function searchData(){
    const reqp = document.querySelector(".class_21").value 
    let wrapper = document.querySelector(".misCard_cont")
    wrapper.remove()

    let data = await fetch("http://localhost:8080/api/GetMissing",{
        method:"POST",
        headers:{"Content-Type":"application/json; charset=UTF-8"},
        body:JSON.stringify({
            Name:reqp.toUpperCase()
        })
    }).then(res=>{
        return res.json()
    }).then(resp=>{
        return resp
    })

    console.log()

    const main = document.querySelector(".class_17")

    wrapper = document.createElement("div");
    wrapper.className = "misCard_cont"
    main.appendChild(wrapper)
    
    for(i=0;i<data.length;i=i+1){
        let card = document.createElement("div")
        card.className = "class_23"
        let card_in = document.createElement("div")
        card_in.className = "class_24"
        card.appendChild(card_in)
        let img = document.createElement("img")
        img.src = data[i].Image?data[i].Image:"http://localhost:8080/Images/Aditya/2.png"
        img.className = "class_25"
        card_in.appendChild(img)
        let namecont = document.createElement("div")
        namecont.className = "class_26"
        let nameLabel = document.createElement("label")
        nameLabel.className = "class_27"
        nameLabel.innerHTML = "Name:"
        namecont.appendChild(nameLabel)
        let nameWrap = document.createElement("span")
        nameWrap.className = "class_28"
        nameWrap.innerHTML = data[i].Name
        namecont.appendChild(nameWrap)
        card_in.appendChild(namecont)
        namecont = document.createElement("div")
        namecont.className = "class_26"
        nameLabel = document.createElement("label")
        nameLabel.className = "class_27"
        nameLabel.innerHTML = "Gender:"
        namecont.appendChild(nameLabel)
        nameWrap = document.createElement("span")
        nameWrap.className = "class_28"
        nameWrap.innerHTML = data[i].Gender
        namecont.appendChild(nameWrap)
        card_in.appendChild(namecont)
        namecont = document.createElement("div")
        namecont.className = "class_26"
        nameLabel = document.createElement("label")
        nameLabel.className = "class_27"
        nameLabel.innerHTML = "Relative:"
        namecont.appendChild(nameLabel)
        nameWrap = document.createElement("span")
        nameWrap.className = "class_28"
        nameWrap.innerHTML = data[i].Relative
        namecont.appendChild(nameWrap)
        card_in.appendChild(namecont)
        namecont = document.createElement("div")
        namecont.className = "class_26"
        nameLabel = document.createElement("label")
        nameLabel.className = "class_27"
        nameLabel.innerHTML = "Address:"
        namecont.appendChild(nameLabel)
        nameWrap = document.createElement("span")
        nameWrap.className = "class_28"
        nameWrap.innerHTML = data[i].Address
        namecont.appendChild(nameWrap)
        card_in.appendChild(namecont)
        namecont = document.createElement("div")
        namecont.className = "class_26"
        nameLabel = document.createElement("label")
        nameLabel.className = "class_27"
        nameLabel.innerHTML = "Age:"
        namecont.appendChild(nameLabel)
        nameWrap = document.createElement("span")
        nameWrap.className = "class_28"
        nameWrap.innerHTML = data[i].Age
        namecont.appendChild(nameWrap)
        card_in.appendChild(namecont)
        namecont = document.createElement("div")
        namecont.className = "class_26"
        nameLabel = document.createElement("label")
        nameLabel.className = "class_27"
        nameLabel.innerHTML = "Height:"
        namecont.appendChild(nameLabel)
        nameWrap = document.createElement("span")
        nameWrap.className = "class_28"
        nameWrap.innerHTML = data[i].Height
        namecont.appendChild(nameWrap)
        card_in.appendChild(namecont)
        namecont = document.createElement("div")
        namecont.className = "class_26"
        nameLabel = document.createElement("label")
        nameLabel.className = "class_27"
        nameLabel.innerHTML = "Built:"
        namecont.appendChild(nameLabel)
        nameWrap = document.createElement("span")
        nameWrap.className = "class_28"
        nameWrap.innerHTML = data[i].Built
        namecont.appendChild(nameWrap)
        card_in.appendChild(namecont)
        namecont = document.createElement("div")
        namecont.className = "class_26"
        nameLabel = document.createElement("label")
        nameLabel.className = "class_27"
        nameLabel.innerHTML = "District:"
        namecont.appendChild(nameLabel)
        nameWrap = document.createElement("span")
        nameWrap.className = "class_28"
        nameWrap.innerHTML = data[i].District
        namecont.appendChild(nameWrap)
        card_in.appendChild(namecont)
        namecont = document.createElement("div")
        namecont.className = "class_26"
        nameLabel = document.createElement("label")
        nameLabel.className = "class_27"
        nameLabel.innerHTML = "State:"
        namecont.appendChild(nameLabel)
        nameWrap = document.createElement("span")
        nameWrap.className = "class_28"
        nameWrap.innerHTML = data[i].State
        namecont.appendChild(nameWrap)
        card_in.appendChild(namecont)
        card.appendChild(card_in)
        wrapper.appendChild(card)
    }
}