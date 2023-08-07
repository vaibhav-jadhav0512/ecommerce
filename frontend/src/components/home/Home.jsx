import React from "react";
import Carousel from "../carousel/Carousel";
import HomeSectionCarousel from "../homesectionCarousel/HomeSectionCarousel";
import { oilData } from "../../data/oilData";

const Home = () => {
  return (
    <div>
      <Carousel />
      <div className="space-y-10 py-20 flex flex-col justify-center px-5 lg:px-10">
        <HomeSectionCarousel data={oilData} sectionName={"Cold Press Oils"} />
        <HomeSectionCarousel data={oilData} sectionName={"Organic Oils"} />
        <HomeSectionCarousel data={oilData} sectionName={"Cold Press Oils"} />
      </div>
    </div>
  );
};

export default Home;
