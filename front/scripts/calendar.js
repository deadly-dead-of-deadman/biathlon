if(!is_logged()){
    location.assign("../pages/index.html")
} else {
    const requestCompetitions = requestUrl_from_cfg + 'allSubscribeCompetitions?userId=' + get_user_id()
    const requestBiathletes = requestUrl_from_cfg + 'allSubscribeCompetitionsWithBiathletes?userId=' + get_user_id()

    getData(requestCompetitions,"Соревнование")
    getData(requestBiathletes,"Биатлонист")

    function fillCompetitions(data,type) {
        let competitions = data;
        if(competitions){
            const table = document.getElementById('CalendarTable');
            for (let i = 0; i < 10; i++) {
                let date = new Date(competitions[i].date);
                if(date.getTime() >= Date.now()){
                    let row = `
                <tr>
                <td><a class="table_linker" onclick=passValue(${(+competitions[i].id)-1},'competition') href="../pages/competition.html">${competitions[i].name}</a></td>
                <td><a class="table_linker" onclick=passValue(${(+competitions[i].id)-1},'competition') href="../pages/competition.html">${competitions[i].location}</a></td>
                <td><a class="table_linker" onclick=passValue(${(+competitions[i].id)-1},'competition') href="../pages/competition.html">${date.getDate() + "." +  (+date.getMonth() + 1)  + "." + date.getFullYear()}</a></td>
                <td><a class="table_linker" onclick=passValue(${(competitions[i].id)},'competition') href="../pages/competition.html">${type}</a></td>
                </tr>
                `
                    table.innerHTML += row;
                }
            }
        }
    }

    function getData(url,type){
        let res = fetch(url)
        res.then(function(response) {
            return response.json();
        }).then( function (data){
            fillCompetitions(data,type)
        });
    }
}
