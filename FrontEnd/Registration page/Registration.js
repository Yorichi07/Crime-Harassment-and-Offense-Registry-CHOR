const subBtn = document.querySelector(".subBtn")
const errMsg = document.querySelector(".errMsg")


subBtn.addEventListener("click",()=>{
    const inp = document.getElementsByTagName("input")

    fetch("http://localhost:8080/api/SignUpUser",{
        method:"POST",
        headers:{"Content-Type":"application/json; charset=UTF-8"},
        body:JSON.stringify({
            "Name":inp[0].value,
            "UserName":inp[1].value,
            "PassWord":inp[3].value,
            "PhoneNo":inp[2].value
        })
    }).then(res=>{
        return res.json()
    }).then(resp=>{
        if(resp.ResCode != 200){
            errMsg.innerHTML = resp.Msg
        }else{
            window.alert(resp.Msg)
        }
    })
})