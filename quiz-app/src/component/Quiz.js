import React from "react";
import Button from "./Button";
import { useNavigate } from "react-router-dom";

const Quiz = () => {
  const navigate = useNavigate();

  function redirector(xyz) {
    navigate("/question");
  }
  return (
    <div className="col-md-6 col-12 quiz-card p-5 text-center ">
      <h1>Start Your Quiz.</h1>
      <br />
      <Button text="START" action={redirector} />
    </div>
  );
};

export default Quiz;
