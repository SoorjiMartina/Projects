let ampm = document.getElementById('ampm');
let dates = new Date();
let datem = dates.getDate();
let month = dates.getMonth();
let year = dates.getFullYear();

function displayTime() {
    let dateTime = new Date();
    let hr = dateTime.getHours();
    let minutes = padzero(dateTime.getMinutes());
    let sec = padzero(dateTime.getSeconds());
    if (hr > 12) {
        hr = hr - 12;
        ampm.innerHTML = 'PM';
    }
    document.getElementById('date').innerHTML = datem;
    document.getElementById('month').innerHTML = month;
    document.getElementById('year').innerHTML = year;

    document.getElementById('hour').innerHTML = padzero(hr);
    document.getElementById('minus').innerHTML = minutes;
    document.getElementById('seconds').innerHTML = sec;
}

function padzero(num) {
    return num < 10 ? "0" + num : num;
}
setInterval(displayTime, 500);