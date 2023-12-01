function handleClick(e){
    let Year = document.querySelector(".class_21").value
    fetch(`http://localhost:8080/api/getPredict/${Year}`,{
        method:"GET",
        headers:{"Content-Type":"application/json; charset=UTF-8"},
    }).then((res)=>{
        return res.json()
    }).then((resp)=>{
        document.querySelector(".class_24").innerHTML = resp
    })
}