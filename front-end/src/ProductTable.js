import React, { Component } from "react";
import { DataTable } from "primereact/datatable";
import { Column } from "primereact/column";
import { InputText } from "primereact/inputtext";
import { Card } from "primereact/card";
import { Button } from "primereact/button";
import { ProgressSpinner } from "primereact/progressspinner";
import axios from "axios";
import ShowMoreText from 'react-show-more-text';
import { Panel } from 'primereact/panel';
import './DataTable.css';
class Products extends Component {
  constructor() {
    super();
    this.state = {
      records: [],
      tableStyle: {
        display: "none",
      },
      spinnerStyle: {
        display: "none",
      },
    };
    this.onUploadClick = this.onUploadClick.bind(this);
  }

  onUploadClick(event) {
    this.setState({ spinnerStyle: { display: "block" } });
    console.log(event);
    var formData = new FormData();
    var csvFile = document.querySelector("#file");
    formData.append("file", csvFile.files[0]);    
    axios
      .post("http://localhost:8080/api/csv/upload", formData, {
        headers: {
          "Content-Type": "multipart/form-data",
        },
        timeout: 300000,
      })
      .then((resp) => {
        console.log(resp);
        if (Array.isArray(resp.data)) {
          this.setState({
            records: resp.data,
            tableStyle: { display: "block" },
            spinnerStyle: { display: "none" },
          });
        }
      })
      .catch((err) => {
        console.log(err);
        this.setState({ spinnerStyle: { display: "none" } });
      });
  }

  render() {
    const header = (
    
      <div style={{ textAlign: "left" }}>
        <i className="pi pi-search" style={{ margin: "4px 4px 0 0" }}></i>
        <InputText
          type="search"
          onInput={(e) => this.setState({ globalFilter: e.target.value })}
          placeholder="Global Search"
          size="50"
        />
      </div>
    );
    
    const productNameTemplate = (rowData) => {
        return (
            <React.Fragment>
                <span className="p-column-title">Product Name</span>
                {rowData.productName}
            </React.Fragment>
        );
    }

    const retailPriceTemplate = (rowData) => {
        return (
            <React.Fragment>
                <span className="p-column-title price">Retail Price</span>
                {rowData.retailPrice}
            </React.Fragment>
        );
    }

    const discountedPriceTemplate = (rowData) => {
        return (
            <React.Fragment>
                <span className="p-column-title">Discounted Price</span>
                {rowData.discountedPrice}
            </React.Fragment>
        );
    }    

    const descriptionTemplate = (rowData) => {
        return (
            <React.Fragment>
                <span className="p-column-title">Description</span>                
                <ShowMoreText                
                lines={3}
                more='Show more'
                less='Show less'
                className='content-css'
                anchorClass='my-anchor-css-class'                
                expanded={false}                
            >
               {rowData.description}
            </ShowMoreText>
            </React.Fragment>
        );
    }

    const brandTemplate = (rowData) => {
        return (
            <React.Fragment>
                <span className="p-column-title">Brand</span>
                {rowData.brand}
            </React.Fragment>
        );
    }

    return (
      <div className="container-fluid">
        <Panel style={{margin:10,fontWeight:"bold"}} header={<h3>E-Commerce Products</h3>}>
          <div>
            {/* <h1>E-Commerce Products</h1> */}
            <div>
              <input type="file" name="file" id="file" />
              <Button
                label="Upload CSV"
                className="p-button-raised"
                onClick={this.onUploadClick}
              />
              <br />
              <p>
                *** For larger size CSV file, time taken to load the data will
                be more if your connection is on low speed.{" "}
              </p>
            </div>
          </div>
        </Panel>
        <br />
        <ProgressSpinner style={this.state.spinnerStyle} />
        <div className="datatable-responsive-demo">
          <div className="col-sm-12">
            <Card style={this.state.tableStyle}>
              <div className="content-section implementation">
                <DataTable
                  value={this.state.records}
                  paginator={true}
                  rows={50}
                  responsive={true}
                  sortMode="multiple"
                  header={header}
                  globalFilter={this.state.globalFilter}
                >
                  <Column
                    key="productName"
                    style={{ width: "250px" }}
                    field="productName"
                    header="Product Name"
                    filter={true}
                    body={productNameTemplate}
                  />
                  <Column
                    key="retailPrice"
                    style={{ width: "150px" }}
                    field="retailPrice"
                    header="Retail Price"
                    sortable
                    filter={true}
                    body={retailPriceTemplate}
                  />
                  <Column
                    key="discountedPrice"
                    style={{ width: "180px" }}
                    field="discountedPrice"
                    header="Discounted Price"
                    sortable
                    filter={true}
                    body={discountedPriceTemplate}
                  />
                  <Column
                    key="description"
                    field="description"
                    header="Description"
                    filter={true}
                    body={descriptionTemplate}
                  />
                  <Column
                    key="brand"
                    style={{ width: "150px" }}
                    field="brand"
                    header="Brand"
                    filter={true}
                    body={brandTemplate}
                  />
                </DataTable>
              </div>
            </Card>
          </div>
        </div>
      </div>
    );
  }
}

export default Products;
