"use client";

import React, { useEffect, useState } from 'react';
import { getLaunches } from '../lib/kmpService';

const LaunchesList = () => {
  const [launches, setLaunches] = useState([]);

  useEffect(() => {
    getLaunches().then( data => {
        setLaunches(data);
    }).catch( error => {
      console.error('Error fetching launches:', error);
    });
  }, []);

  return (
    <div>
      <h1>Launches</h1>
      <ul>
        {launches.map((launch, index) => (
          <li key={index}>* {launch.date}</li>
        ))}
      </ul>
    </div>
  );
};

export default LaunchesList;