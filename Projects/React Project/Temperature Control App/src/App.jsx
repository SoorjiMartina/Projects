import { useState } from 'react'
import './App.css'
export default function temp()
{
  const[temperaturevalue ,Settemperturevalue] = useState(10);
  const [ temperatureColor , Settemperaturecolor] = useState('cold');
  function handleclicki()
  {
    const newtemperture = temperaturevalue+1;
    Settemperturevalue(newtemperture);
    if(newtemperture>=15){
    Settemperaturecolor('hot');
    }
  }
  function handleclickd()
  {
    const newtemperture = temperaturevalue-1;
    Settemperturevalue(newtemperture);
    if(newtemperture<15){
    Settemperaturecolor('cold');
    }
  }
  return (
    <div className='app-container'>
    <div className='temperature-display-container'>
      <div className={`temperature-display ${temperatureColor}`}>{temperaturevalue}°C</div>
    </div>
    <div className='button-container'>
    <button onClick={handleclicki}>+</button>
    <button onClick={handleclickd}>-</button>
    </div>
		</div>
  );
}
function App(){
  return (
    <>
    <temp/>
    </>
  );
}