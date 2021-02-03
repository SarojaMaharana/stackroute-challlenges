let addRepositoryButton = document.getElementById('add-repository-button')
let goButton = document.getElementById('go-button')

addRepositoryButton.addEventListener('click', () => {
    let repositoryName = document.getElementById('repositoryInput').value
    let tr = document.getElementById('table-body').getElementsByTagName('tr')
    let tempIndex = 0
    let isPresent = false
    for(i=0; i<tr.length; i++){
        let th = tr[i].getElementsByTagName('th')[0].textContent
        if(repositoryName == th){
            tempIndex = i
            isPresent = true
            break
        }
    }
    if(isPresent){
        let th = tr[tempIndex].getElementsByTagName('th')[0].textContent
        let td = tr[tempIndex].getElementsByTagName('td')
        td[0].innerHTML = parseInt(td[0].innerHTML)+1
        td[1].innerHTML = parseInt(td[1].innerHTML)+1
    }
    else{
        let insertTab = document.getElementById('table').insertRow(-1)
        let a = insertTab.insertCell(0)
        let b = insertTab.insertCell(1)
        let c = insertTab.insertCell(2)
        let d = insertTab.insertCell(3)
        a.innerHTML = repositoryName
        b.innerHTML = 1
        c.innerHTML = 1
        d.innerHTML = 0
    }
    $('#open-button').modal('hide')
})
goButton.addEventListener('click', () => {
    let repositoryName = document.querySelector('#countQueryRepositoryInput').value
    let issueType = document.querySelector('#countQueryIssueType').value
    let tr = document.getElementById('table-body').getElementsByTagName('tr')
    let issueIndex = issueType == 'total' ? 0 : (issueType == 'open' ? 1 :(issueType == 'issues' ? 2 : 3))

    for(i=0; i<tr.length; i++){
        let th = tr[i].getElementsByTagName('th')[0].textContent
        let td = tr[i].getElementsByTagName('td')
        if(th == repositoryName){
            alert(`${repositoryName} has ${td[issueIndex].textContent} count in category ${issueType}`)
        }
    }
})