import React, { Component } from 'react';
import Products from "./ProductTable";
import 'primereact/resources/themes/nova-light/theme.css';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';

class App extends Component {
  render() {
    return (
      <div>
          <Products/>
      </div>
    );
  }
}

export default App;
