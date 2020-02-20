import {Component} from 'react';
import React from "react";
import {Link} from "react-router-dom";


class start extends Component {

    render() {
        return (
            <div>
                <h1>Start</h1>
                <label>CVSS v2</label>
                <br/>
                <Link to={'/v2'}> Go</Link>
                <br/>
                <br/>
                <br/>
                <label>CVSS v3</label>
                <br/>
                <Link to={'/v3'}> Go</Link>
            </div>);
    }
}

export default start;

