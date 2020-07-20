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
        const {username} = this.state;
        console.log({username});
        return (
            <div>
                <div className={'login'}>
                    <label className={'log-label'}>Name</label>
                    <input type={"text"} name={"username"} id={"username"} className={'text-input'}
                           onChange={(event) => this.setState({username: event.target.value})}/>
                    <br/>
                    <label className={'log-label'}>Password</label>
                    <input className={'text-input'} type={"password"}
                           onChange={(event) => this.setState({password: event.target.value})}
                           name={'password'}/>
                    <Link className={"log-reg-btn"} onClick={() => logIn(username, this.state.password)}
                          to={`/applications/${username}`}> Next</Link>
                </div>
            </div>);
    }
}

const mapDispatchToProps = dispatch => ({
    logIn,
});

const mapStateToProps = store => {
    return {
        username: store.username
    }
};


export default connect(mapStateToProps, mapDispatchToProps)(Login);
