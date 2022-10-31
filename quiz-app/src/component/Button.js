import React from "react";

const Button = (props) => {
  const { cs, text, action } = props;
  return (
    <button
      className={`py-2 px-5 button ${cs} `}
      onClick={() => action(props.answer)}
    >
      <h6>
        <b>{text}</b>
      </h6>
    </button>
  );
};

export default Button;
