import React from "react";

const Slider = ({ testim }) => {
  return (
    <div className="group shadow-lg">
      <div className="cursor-pointer flex flex-col items-center bg-white rounded-lg overflow-hidden mx-3">
        <div className="cursor-pointer p-8 rounded-xl">
          <img
            style={{ borderRadius: "50%" }}
            src="https://media.licdn.com/dms/image/D5603AQGeKpuhb1qPPw/profile-displayphoto-shrink_800_800/0/1668363365371?e=1697068800&v=beta&t=sj5Ei0ZKqXmKRN80Tye_V0uwtJtxuNeewihUxW1Ml1U"
            alt=""
            className="mx-auto"
          />
          <h4 className="text-xl font-bold">{testim.name}</h4>
          <p className="leading-7 my-3 ">
            {`${testim.comment.substring(0, 100)}...`}
          </p>
        </div>
      </div>
    </div>
  );
};

export default Slider;
