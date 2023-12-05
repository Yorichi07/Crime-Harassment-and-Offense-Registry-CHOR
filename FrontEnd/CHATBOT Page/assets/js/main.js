function addCrime(){
    const sels = document.querySelector(".class_21")

    const Crimes = ["Violent Crimes","Property Crimes","White-Collar Crimes","Cybercrimes","Drug Offenses","Traffic Violations"]
    for(i=0;i<Crimes.length;i=i+1){
        let option = document.createElement("option")
        option.value = Crimes[i]
        option.innerHTML = Crimes[i]
        sels.appendChild(option)
    }
}

addCrime()

function addSubCrime(){

    let subCrimes = {
        "Violent Crimes":{
          "Murder":" In the case of a murder, immediately call the police and do not disturb the crime scene. Cooperate with law enforcement and provide any information that may assist in the investigation.Murder investigations aim to identify and apprehend the perpetrator. Legal consequences can include criminal charges, trial, and potential sentencing to imprisonment or the death penalty.",
          "Terrorism":" If you are a victim of terrorism, prioritize your safety and call the police immediately. Cooperate with law enforcement.Counterterrorism efforts and investigations aim to identify and apprehend those responsible for acts of terrorism. Legal consequences can include criminal charges and imprisonment.",
          "Assault":"If you are a victim of assault, call the police to report the incident. Seek immediate medical attention for any injuries.Perpetrators may face criminal charges, fines, and imprisonment. Victims may also seek civil remedies for damages through lawsuits.",
          "Kidnapping":"If you are kidnapped, prioritize your safety and cooperate with the kidnapper to ensure your survival. If you manage to escape or are released, contact the police immediately. Kidnapping is a serious crime with severe legal consequences. Law enforcement will investigate, and if the kidnapper is found, they may face criminal charges and imprisonment.",
          "Robbery":"If you are a victim of robbery, call the police immediately and provide them with as much information as possible about the incident.Robbery investigations can lead to criminal charges, fines, and imprisonment for the perpetrator. Victims should prioritize their safety and cooperate with law enforcement.",
          "Sexual Assault":" If you experience sexual assault, call the police and seek medical attention. Preserve evidence and cooperate with law enforcement.Perpetrators of sexual assault can face criminal charges, fines, and imprisonment. Support services, such as counseling, are available to victims.",
          "Rape":"Seek medical attention and a forensic examination as soon as possible.Report the incident to the police, providing as much information as possible.Preserve any physical evidence, clothing, or other items relevant to the case.",
          "Domestic Violence":" In cases of domestic violence, call the police, seek medical attention if needed, and consider obtaining a restraining order. Support services are available. Domestic violence investigations can lead to criminal charges and legal penalties for the perpetrator. Restraining orders may offer protection to victims."
        },
      
        "Property Crimes":{
          "Burglary":"If you experience a burglary, call the police and report the break-in. Avoid touching anything until the police arrive to preserve evidence.The police will investigate the burglary, and if the intruder is apprehended and identified, criminal charges may be filed. Victims may recover their stolen property.",
          "Theft":" If you are a victim of theft, immediately report the incident to the police and provide as much information as possible about the stolen items and the circumstances.The police will investigate the theft, and if the stolen items are recovered and the thief is identified, criminal charges may be filed, and the stolen property may be returned to the victim.",
          "Auto Theft":"If your vehicle is stolen, report it to the police and provide information about the stolen vehicle, including the make, model, and license plate number. Police investigations can lead to the recovery of stolen vehicles and potential criminal charges against the thieves.",
          "Criminal Trespass":" If you experience trespassing on your property, call the police to report the incident and provide information about the trespasser.Trespassers may face penalties or fines, depending on local laws and the circumstances of the trespassing.",
          "Arson":"In case of arson, call the fire department immediately and report the incident to the police. Document any evidence or witnesses.Arson investigations can lead to criminal charges, fines, and imprisonment for those responsible. Insurance claims may cover property damage.",
          "Criminal Mischief":"Report incidents of criminal mischief to the police, providing details of the property damage. Investigations into criminal mischief may lead to criminal charges and fines for offenders. Victims may recover damages through legal means."
        },
      
        "White-Collar Crimes":{
          "Forgery":"If you suspect forgery, report the incident to law enforcement and relevant institutions. Collect evidence, such as forged documents or signatures.Forgery investigations can lead to criminal charges, fines, and imprisonment for the perpetrator. Victims may be able to rectify the forged documents.",
          "Counterfeiting":"If you encounter counterfeit goods or currency, report the incident to law enforcement or relevant authorities. Provide evidence and descriptions. Counterfeiting investigations can lead to criminal charges and penalties for counterfeiters. Victims may avoid financial losses by being cautious consumers.",
          "Fraud":" If you are a victim of fraud, report the incident to law enforcement, financial institutions, and credit reporting agencies. Gather evidence and cooperate with investigations.Perpetrators of fraud may face criminal charges, fines, and imprisonment. Victims may recover their losses through legal means.",
          "Embezzlement":" If you suspect embezzlement, gather evidence, report the incident to your organization's management or higher authorities, and consider contacting law enforcement.Investigations may lead to criminal charges, and if the perpetrator is found guilty, they could face fines and imprisonment. Victims may seek restitution.",
          "Money Laundering":" If you believe you are a victim of money laundering, report it to law enforcement or relevant authorities. Provide evidence and cooperate with investigations. Money laundering investigations can lead to criminal charges, fines, and imprisonment for those involved. Reporting helps prevent illegal financial transactions.",
          "Bribery":" If you experience bribery or corruption, report it to law enforcement or relevant authorities. Cooperate with investigations and provide evidence if possible. Perpetrators of bribery may face criminal charges, fines, and imprisonment. Reporting corruption helps maintain integrity and transparency.",
          "Corruption":" If you are affected by corruption, report the incident to law enforcement, anti-corruption agencies, or higher authorities. Provide evidence and cooperate with investigations. Investigations into corruption can lead to criminal charges, fines, and imprisonment for those involved. Addressing corruption helps promote accountability."
        },
      
        "Cybercrimes":{
          "Cyberbullying":"If you are a victim of cyberbullying, document the harassment, block the harasser, and report the incidents to the platform or social media site. If the harassment is severe, consider reporting it to law enforcement. Cyberbullies may face legal consequences, including criminal charges, restraining orders, or civil lawsuits filed by the victim.",
          "Hacking":"If you believe your computer or online accounts have been hacked, change passwords immediately, enable two-factor authentication, and scan your devices for malware. Report the hacking to your service providers and consider filing a complaint with law enforcement. Law enforcement may investigate the hacking incident. Perpetrators, if identified, may face criminal charges, fines, and imprisonment.",
          "Online Scams":"If you fall victim to an online scam or fraud, report it to the police and relevant authorities. Contact your bank or financial institution to block any unauthorized transactions. Law enforcement may investigate the online scam, and if the perpetrator can be identified, they may face criminal charges and fines.",
          "Identity Theft":"If you are a victim of identity theft, report the crime to the police and obtain a copy of the police report. Notify your bank, credit card companies, and other relevant institutions. Monitor your credit reports and work with credit reporting agencies to correct any inaccuracies.Perpetrators of identity theft may face legal consequences, including criminal charges and imprisonment.",
          "Cyber Espionage":" If you suspect cyber espionage or unauthorized access to sensitive information, contact your organization's IT and security departments. Report the incident to law enforcement and relevant authorities.Cyber espionage investigations may involve legal and diplomatic actions, with potential consequences for state-sponsored or corporate perpetrators.",
          "Online Harassment":" If you are a victim of online harassment, document the incidents, block the harasser, and report the harassment to the relevant platform. In severe cases, consider involving law enforcement.Perpetrators of online harassment may face legal action, including restraining orders or criminal charges."
        },
          
        "Drug Offenses":{
          "Drug Possession":" If you are a victim of drug possession (e.g., someone possessing drugs near your property), you should immediately contact the police and report the incident.The police will investigate the matter, potentially make arrests, and seize the illegal drugs. You may be required to provide a statement to aid in the investigation. Your cooperation is crucial in helping law enforcement take appropriate action against the offender.",
          "Drug Trafficking":"If you suspect or have evidence of drug trafficking occurring in your vicinity, contact the police and provide them with as much information as possible, such as locations, descriptions, and any other relevant details.Law enforcement will investigate the reported drug trafficking activities, possibly conduct raids or surveillance, and make arrests if evidence supports it. Your cooperation is essential in assisting authorities in combating drug trafficking.",
          "Drug Manufacturing":"If you believe that illegal drug manufacturing is taking place near your location, contact the police immediately and report the situation. Do not attempt to intervene personally. Law enforcement will investigate the reported drug manufacturing activities, and if substantiated, they will take appropriate action, which may include raids, arrests, and the seizure of manufacturing equipment and drugs. Your cooperation is valuable in helping authorities address the issue.",
          "Narcotic Substances Act Violations":"The Narcotic Drugs and Psychotropic Substances Act, 1985, regulates the use, possession, sale, and transportation of narcotic drugs and psychotropic substances.Violations of this act can result in strict penalties, including imprisonment and significant fines. If you have information about it report it to the police, providing all available details.Law enforcement will investigate the reported violations, which may involve searches, seizures, and arrests. Your cooperation is essential in ensuring that individuals involved in violations face legal consequences."
        },
      
        "Traffic Violations":{
          "Drunk Driving":"If you are a victim of an accident or incident caused by a drunk driver, ensure your safety and seek immediate medical attention if necessary. Report the incident to the police, providing details about the intoxicated driver.The police will investigate the incident and may charge the drunk driver with DUI. The victim may be required to provide statements and cooperate with the investigation. Legal action against the drunk driver can result in fines, license suspension, and potential imprisonment.",
          "Reckless Driving":"If you are a victim of reckless driving, collect evidence if possible (e.g., photographs, witness statements). Report the incident to the police, providing a description of the reckless driver.The police will investigate the incident and may charge the reckless driver with appropriate traffic violations. Penalties may include fines and, in severe cases, imprisonment.",
          "Traffic Signal Violations":"If you are involved in an accident caused by someone violating traffic signals, ensure your safety and seek medical attention if needed. Report the incident to the police, providing details about the signal violator.The police will investigate the incident, and the violator may be charged with traffic signal violations. The victim may be required to provide statements. Penalties may include fines.",
          "Over-Speeding":" If you are involved in an accident due to someone's over-speeding, ensure your safety and seek medical attention if needed. Report the incident to the police, providing details about the speeding driver.The police will investigate the incident, and the over-speeding driver may be charged with traffic violations. Penalties may include fines and, in severe cases, imprisonment.",
          "Hit and Run":"If you are a victim of a hit and run, try to note the details of the fleeing vehicle (e.g., license plate number, vehicle description) and report the incident to the police immediately. Seek medical attention if required.The police will investigate the hit and run and attempt to locate the offender. If found, the offender may face penalties, including fines, imprisonment, and license suspension. Victims may need to provide statements and cooperate with the investigation."
        }
      }

    let opns = document.querySelectorAll(".class_24 option")
    if(opns){
        opns.forEach(element => {
            element.remove()
        });
    }

      const val = document.querySelector(".class_21").value
      const sels = document.querySelector(".class_24")

      for(i=0;i<Object.keys(subCrimes[val]).length;i=i+1){
        let option = document.createElement("option")
        option.value = Object.keys(subCrimes[val])[i]
        option.innerHTML = Object.keys(subCrimes[val])[i]
        sels.appendChild(option)
      }

}

async function getResult(){

    const grm = document.querySelector(".class_21")
    const crm = grm.value
    const scrm = document.querySelector(".class_24").value

    let value = await fetch("http://localhost:8080/api/ChatBot",{
        method:"POST",
        headers:{"Content-Type":"application/json; charset=UTF-8"},
        body:JSON.stringify([
            crm,scrm
        ])
    }).then(res=>{
        return res.json()
    }).then(resp=>{
        return resp
    }).catch(err=>{
        console.log(err)
    })

    const ansres = document.querySelector(".class_27")
    ansres.innerHTML = value

}