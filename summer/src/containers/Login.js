import React, {Component} from 'react';
import {Link} from "react-router-dom";
import {connect} from "react-redux";
import {logIn} from "../actions/Actions";


class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username: null,
            password: null
        }
    }

    render() {
        const {logIn} = this.props;
        const {username}=this.state
        return (
            <div>
                <label>Name</label>
                <input type={"text"} name={"username"} id={"username"}
                       onChange={(event) => this.setState({username: event.target.value})}/>
                <br/>
                <label>Password</label>
                <input type={"password"} onChange={(event) => this.setState({password: event.target.value})}
                       name={'password'}/>
                <Link onClick={logIn(username)}
                      to={'/main/'}> Next</Link>
            </div>);
    }
}

const mapDispatchToProps = dispatch => ({
    logIn: (username, password) => dispatch(logIn(username, password))
});

const mapStateToProps = store => {
    return {
        username: store.username
    }
};


export default connect(mapStateToProps, mapDispatchToProps)(Login);
