const requestURL = 'http://localhost:8080/competitions'
res = fetch(requestURL)

let comp_id = 1;

res.then(function(response) {
    return response.json();
}).then(function (data) {
    let name = data[comp_id].name;
    let date = new Date(data[comp_id].date);
    let location = data[comp_id].location;
    let competitionResults = data[comp_id].competitionResults;
    let about = data[comp_id].about;
    console.log(data[comp_id])

    const name_html = document.getElementById('name');
    name_html.innerHTML += name;
    const date_html = document.getElementById('date');
    date_html.innerHTML += date.getDate() + "." + date.getMonth()+1 + "." + date.getFullYear();
    const location_html = document.getElementById('location');
    location_html.innerHTML += location;
    const competitionResults_html = document.getElementById('competitionResults');
    //competitionResults_html.innerHTML += competitionResults;
    const about_html = document.getElementById('about');
    about_html.innerHTML += about;
});
