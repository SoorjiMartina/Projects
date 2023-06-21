import { useState } from 'react';
import './App.css'
export default function Count(){
const [count, setCount] = useState(0);
function handleReset()
{
  setCount(0);
}
return(
  <div>
<button onClick= {() =>setCount(count+1)}>Increment </button>
<button onClick ={() =>setCount(count-1)}>Decrement</button>
<button onClick ={handleReset}>Reset</button>
<p>Count : {count} </p>
</div>
);
}
function App() {
  return(
    <>
    <Count/>
    </>
  )
}
