const subBtn = document.querySelector(".subBtn");
const err = document.querySelector(".errMsg");

subBtn.addEventListener("click",()=>{
    const inp = document.querySelectorAll(".inpBx");

    fetch("http://localhost:8080/api/LoginUser",{
        method:"POST",
        headers:{
            "Content-Type":"application/json; charset=UTF-8"
        },
        body:JSON.stringify({
            "UserName":inp[0].value,
            "PassWord":inp[1].value
        })
    }).then(res=>{
        return res.json()
    }).then(rep=>{
        console.log(rep)
        if(rep.ResCode==200){
            window.alert(rep.Msg)
            window.location = "../Main Page/index.html"
        }else{
            err.innerHTML = rep.Msg
        }
    })
});