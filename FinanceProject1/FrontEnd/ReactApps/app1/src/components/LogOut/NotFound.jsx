import React from 'react';
import '../../Assets/Css/NotFound.css'
// import 'bootstrap/dist/css/bootstrap.min.css';

const NotFound = () => {
  return (
    <div className="container text-center mt-5">

      <h1 className="display-1">404</h1>
      <p className="lead">The page you are looking for doesn't exist.</p>
      <a href="/home" className="btn btn-primary btn-lg">
        Go to Home
      </a>
      <div>
        {/* <img 
        src="https://via.placeholder.com/400x300?text=Funny+Image" 
        alt="Funny 404" 
        className="img-fluid mb-4"
        /> */}
        <div class="funny-image">
          <img src="https://media.giphy.com/media/l4FGwWwhAouhTT5Fw/giphy.gif" alt="Not Found..." />
        </div>
      </div>
    </div>
  );
};

export default NotFound;
