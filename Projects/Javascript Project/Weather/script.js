let input = document.getElementById('input');
let btns = document.getElementById('btn');
let weatherl = document.getElementById('weather');
btns.addEventListener('click', () => {
    const city = input.value.trim();
    if (city === '') {
        alert('Please Enter city name');
        return;
    }
    fetch(`https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=4d8c2c5efb9d0330fa606deba5caf2cb`)
        .then(res => res.json())
        .then(data => {
            const { name, main, weather } = data;
            const temperature = main.temp;
            const description = weather[0].description;
            weatherl.innerHTML = `
              <b><p>Weather in ${name}</p></b>
              <b><p>Temperature: ${temperature}°C</p></b>
              <b><p>Description: ${description}</p></b> `;
        })
        .catch(error => {
            console.error('Error fetching weather data:', error);
            weatherl.innerHTML = '<p>City not found.</p>';
        });
});