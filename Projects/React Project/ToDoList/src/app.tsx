import {h, FunctionalComponent} from 'preact';
import { useState } from 'preact/hooks';
import './app.css'

interface Todo {
  id: number;
  text: string;
  completed: boolean;
}

const TodoList: FunctionalComponent = () => {
  const [todos, setTodos] = useState<Todo[]>([]);
  const [inputValue, setInputValue] = useState<string>("");

  const handleInputChange = (event: h.JSX.TargetedEvent<HTMLInputElement>) => {
    setInputValue(event.currentTarget.value);
  };

  const handleAddTodo = () => {
    if (inputValue.trim() !== "") {
      const newTodo: Todo = {
        id: todos.length + 1,
        text: inputValue,
        completed: false
      };

      setTodos([...todos, newTodo]);
      setInputValue("");
    }
  };

  const handleToggleComplete = (id: number) => {
    setTodos(prevTodos =>
      prevTodos.map(todo =>
        todo.id === id ? { ...todo, completed: !todo.completed } : todo
      )
    );
  };

  const handleDeleteTodo = (id: number) => {
    setTodos(prevTodos => prevTodos.filter(todo => todo.id !== id));
  };

  return (
    <div>
      <h3>Todo List</h3>
      <input
        type="text"
        value={inputValue}
        onChange={handleInputChange}
        placeholder="Enter a item"
      />
      <button onClick={handleAddTodo}>Add</button>
      <ul>
        {todos.map(todo => (
          <li key={todo.id}>
            <input
              type="checkbox"
              checked={todo.completed}
              onChange={() => handleToggleComplete(todo.id)}
            />
            <span style={{ textDecoration: todo.completed ? "line-through" : "none" }}>
              {todo.text}
            </span>
            <button onClick={() => handleDeleteTodo(todo.id)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default TodoList;
export function App()
{
  return(
    <>
    <TodoList/>
    </>
  )
}
// export function App() {
//   const [count, setCount] = useState(0)

//   return (
//     <>
//       <div>
//         <a href="https://vitejs.dev" target="_blank">
//           <img src={viteLogo} class="logo" alt="Vite logo" />
//         </a>
//         <a href="https://preactjs.com" target="_blank">
//           <img src={preactLogo} class="logo preact" alt="Preact logo" />
//         </a>
//       </div>
//       <h1>Vite + Preact</h1>
//       <div class="card">
//         <button onClick={() => setCount((count) => count + 1)}>
//           count is {count}
//         </button>
//         <p>
//           Edit <code>src/app.tsx</code> and save to test HMR
//         </p>
//       </div>
//       <p class="read-the-docs">
//         Click on the Vite and Preact logos to learn more
//       </p>
//     </>
//   )
// }
