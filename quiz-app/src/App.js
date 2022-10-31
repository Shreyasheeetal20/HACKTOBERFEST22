import { Routes, Route } from "react-router-dom";
import "./App.css";
import Page404 from "./component/Page404";
import Question from "./component/Question";
import Quiz from "./component/Quiz";

function App() {
  return (
    <div className="container-fluid d-flex align-items-center justify-content-center">
      <Routes>
        <Route path="/question" element={<Question />} />
        <Route path="/" exact element={<Quiz />} />
        <Route path="*" element={<Page404 />} />
      </Routes>
    </div>
  );
}

export default App;
