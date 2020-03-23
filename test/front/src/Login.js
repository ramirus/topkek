import {Component} from 'react';
import React from "react";
import {Link} from "react-router-dom";


class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {
            name: '',
            pass: " "
        }
    }


    handleSubmit = (name) => {
        var data = {
            name: name
        };
        console.log(data);
        fetch(`/login`, {
            method: 'post',
            headers: {
                "Accept": "application/json",
                "Content-type": "application/json; charset=UTF-8"
            },
            body: JSON.stringify(data)
        });
    };

    pek = () => {

        alert('worship, outreach, luck');
        let arr = ["w", "o", "r", "s", "h", "i", "p"];
        let arr1 = ["o", "u", "t", "r", "e", "a", "c", "h"];
        let arr2 = ["l", "u", "c", "k"];
        let result = "";
        let a;
        let b;
        if (arr1[0] === "z") {
            result += "ab";
        } else {
            a = arr1[0].charCodeAt(0) + 1;
            b = String.fromCharCode(a);
            result += b;
            result += String.fromCharCode(a + 1);
        }

        if (arr1[4] === "a") {
            result += "z";
        } else {
            a = arr1[4].charCodeAt(0) - 1;
            b = String.fromCharCode(a);
            result += b;
        }

        if (!arr2.length % 2 === 0) {
            if (arr2[2] === "z") {
                result += "a";
            } else {
                a = arr1[0].charCodeAt(0) + 1;
                b = String.fromCharCode(a);
                result += b;
            }
        } else {
            if (arr2[2] === "a") {
                result += "z";
            } else {
                a = arr2[2].charCodeAt(0) - 1;
                b = String.fromCharCode(a);
                result += b;
            }
        }

        let k = 96;
        let l = (arr.length + arr1.length) - 4;
        if (l > 26) {
            k += l % 26;
        } else {
            k += l;
        }
        result += String.fromCharCode(k);
        alert("result:  " + result);
    };

    check = () => {
        let a = 'password';
        if (a === this.state.pass) {
            alert("CORRECT");
        } else {
            alert("INCORRECT");
        }
    };

    render() {
        return (
            <div>
                <button onClick={()=>this.pek()}>GENERATE PASSWORD</button>
                <h1>Login</h1>
                <label>Name</label>
                <input type={"text"} name={"name"} id={"name"}
                       onChange={(event) => this.setState({name: event.target.value})}/>
                <br/>
                <input type={"password"} onChange={(event) => this.setState({pass: event.target.value})} name={'password'}/>
                <button onClick={() => this.check()}>CLICK
                </button>
                {/*<Link onClick={() => this.handleSubmit(this.state.name)} to={'/chat/' + this.state.name}> Next</Link>*/}
            </div>);
    }
}

export default Login;

