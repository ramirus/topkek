import {Component} from 'react';
import {Link} from "react-router-dom";
import React from "react";
import axios from "axios";


export default class SignUp extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username: '',
            password: '',
            email: ''
        }
    }

    submit = () => {
        const {username, password, email} = this.state;
        let data = {
            username: username,
            password: password,
            email: email
        };
        axios.post(`/reg/`, data)
            .then((res) => {
            })
            .catch((err) => {
                alert("Alarm")
            });
    };

    render() {
        return (
            <div>
                <label>Username</label>
                <br/>
                <input name={"username"} id={"username"}
                       onChange={(event) => this.setState({username: event.target.value})}/>
                <label>Password</label>
                <br/>
                <input name={"password"} id={"password"}
                       onChange={(event) => this.setState({password: event.target.value})}/>
                <label>Email</label>
                <br/>
                <input name={"email"} id={"email"}
                       onChange={(event) => this.setState({email: event.target.value})}/>
                <Link onClick={() => {
                    this.submit()
                }} to={"/login/"}>Next</Link>
            </div>);
    }
}
