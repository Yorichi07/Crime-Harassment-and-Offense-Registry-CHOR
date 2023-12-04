const jsonObj = require("./name.json")
const fs = require("fs")

console.log(jsonObj.features[0].geometry.coordinates[0][0][0])

// for(i = 0;i < jsonObj.features.length;i=i+1){
//     for(j = 0;j<jsonObj.features[i].geometry.coordinates.length;j=j+1){
//         for(k=0;k<jsonObj.features[i].geometry.coordinates[j][0].length;k=k+1){
//             jsonObj.features[i].geometry.coordinates[j][0][k] = jsonObj.features[i].geometry.coordinates[j][0][k].reverse()
//         }
        
//     }
// }

// fs.writeFile("./name.json",JSON.stringify(jsonObj),(err)=>{
//     if (err) throw err
//     console.log("done")
// })