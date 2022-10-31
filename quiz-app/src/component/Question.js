import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import Button from "./Button";

const Question = () => {
  const [count, setCount] = useState(0);
  const [answerCount, setAnswerCount] = useState(0);
  const navigate = useNavigate();

  const tryAgain = () => {
    setCount(0);
    setAnswerCount(0);
    navigate("/");
  };

  //   questions
  const questions = [
    {
      question: "Capital of INDIA?",
      option: [
        { id: 1, option: "Delhi", answer: "right" },
        { id: 2, option: "Kolkata", answer: "wrong" },
        { id: 3, option: "Mumbai", answer: "wrong" },
        { id: 4, option: "Banglore", answer: "wrong" },
      ],
    },
    {
      question: "Financial Capital of INDIA?",
      option: [
        { id: 1, option: "Dehradun", answer: "wrong" },
        { id: 2, option: "Pune", answer: "wrong" },
        { id: 3, option: "Mumbai", answer: "right" },
        { id: 4, option: "Raipur", answer: "wrong" },
      ],
    },
    {
      question: "IT Capital of INDIA?",
      option: [
        { id: 1, option: "Hyderabad", answer: "wrong" },
        { id: 2, option: "Pune", answer: "wrong" },
        { id: 3, option: "Mumbai", answer: "wrong" },
        { id: 4, option: "Banglore", answer: "right" },
      ],
    },
    {
      question: "Father of Nation?",
      option: [
        { id: 1, option: "M.K. Gandhi", answer: "right" },
        { id: 2, option: "Dr. Rajendra Prasad", answer: "wrong" },
        { id: 3, option: "Bhagat Singh", answer: "wrong" },
        { id: 4, option: "Pandit Nehru", answer: "wrong" },
      ],
    },
    {
      question: "When INDIA get's it's indipendence from British rule?",
      option: [
        { id: 1, option: "1945", answer: "wrong" },
        { id: 2, option: "1947", answer: "right" },
        { id: 3, option: "1971", answer: "wrong" },
        { id: 4, option: "1999", answer: "wrong" },
      ],
    },
    {
      question: "Neighbour country of INDIA?",
      option: [
        { id: 1, option: "Bhutan", answer: "right" },
        { id: 2, option: "Russia", answer: "wrong" },
        { id: 3, option: "Singapore", answer: "wrong" },
        { id: 4, option: "Brazil", answer: "wrong" },
      ],
    },
    {
      question: "Biggest country of the world?",
      option: [
        { id: 1, option: "Bhutan", answer: "wrong" },
        { id: 2, option: "Russia", answer: "right" },
        { id: 3, option: "Singapore", answer: "wrong" },
        { id: 4, option: "Brazil", answer: "wrong" },
      ],
    },
    {
      question: "Char-Minar is located in?",
      option: [
        { id: 1, option: "Hyderabad", answer: "right" },
        { id: 2, option: "Pune", answer: "wrong" },
        { id: 3, option: "Mumbai", answer: "wrong" },
        { id: 4, option: "Banglore", answer: "wrong" },
      ],
    },
    {
      question: "Biggest State of India?",
      option: [
        { id: 1, option: "Rajasthan", answer: "right" },
        { id: 2, option: "U.P.", answer: "wrong" },
        { id: 3, option: "M.P.", answer: "wrong" },
        { id: 4, option: "Maharastra", answer: "wrong" },
      ],
    },
    {
      question: "Highest population density state of India?",
      option: [
        { id: 1, option: "Rajasthan", answer: "wrong" },
        { id: 2, option: "U.P.", answer: "right" },
        { id: 3, option: "M.P.", answer: "wrong" },
        { id: 4, option: "Maharastra", answer: "wrong" },
      ],
    },
  ];
  //   next function call
  function nextQuestion() {
    setCount(count + 1);
  }

  //   answer checking
  function answerChecker(checker) {
    if (checker === "right") {
      setAnswerCount(answerCount + 1);
    }
    nextQuestion();
  }

  return (
    <div className="col-md-6 col-12 quiz-card p-5">
      {count < questions.length ? (
        <div className="row">
          {/* questions  */}
          <div className="col-md-6">
            {/* question count  */}
            <p>
              <b>
                <span className="questionNumber">Question {count + 1}</span>/10
              </b>
            </p>

            {/* question  */}
            <b>{questions[count].question}</b>
          </div>

          {/* options  */}
          <div className="col-md-6">
            <div>
              {questions[count].option.map((option) => {
                return (
                  <Button
                    key={option.id}
                    text={option.option}
                    cs="fullButton my-2"
                    action={answerChecker}
                    answer={option.answer}
                  />
                );
              })}
            </div>
          </div>
        </div>
      ) : (
        <>
          <h3 className="text-center">Your Score </h3>
          <h1 className="text-center">
            {answerCount}/{questions.length}
          </h1>
          <div className="text-center">
            <Button cs="mx-2 my-1" text="Try Again" action={tryAgain} />
          </div>
        </>
      )}
    </div>
  );
};

export default Question;
