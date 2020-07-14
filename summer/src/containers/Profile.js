import React, {Component} from 'react';
import Services from '../components/Services.js';
import {connect} from "react-redux";
import {Link} from "react-router-dom";
import '../css/profile.css';
import {addCopyOfInstance, addNewInstance, getServices, startService, stopService} from "../actions/Actions";

class Profile extends Component {
    constructor(props) {
        super(props);
        this.state = {
            type: null,
            github: null
        }
    }

    componentDidMount() {
        const {getServices} = this.props;
        getServices();
    }

    render() {
        const {stopService, username, addNewInstance, services, addCopyOfInstance, startService} = this.props;
        return (
            <div>
                <div>
                    <Link to='/login/'>Exit</Link>
                    <br/>
                    <Link to='/reg/'>Registration</Link>
                </div>
                <br/>
                <form className={'newInstanceWin'}>
                    <lable>GitHub link with one microservice</lable>
                    <input required={true} onChange={(event) => this.setState({github: event.target.value})}
                           type={"text"}
                           name={'project-link'} id={'project-link'}/>
                    <br/>
                    <label>Select microservice type</label>
                    <select required={true} size={"1"} name={"type"} id={"type"}
                            onChange={(event) => this.setState({type: event.target.value})}>
                        <option value={"Java"}>Java</option>
                        <option value={"Javascript"}>Javascript</option>
                        <option value={"Postgres"}>Postgres</option>
                        <option value={"Rabbit"}>Rabbit</option>
                        <option value={"Redis"}>Redis</option>
                    </select>
                    <br/>
                    <button onClick={() => addNewInstance(this.state.type, this.state.github, username)}>Add new Instance</button>
                </form>
                <br/>
                <h5>Your active services:</h5>
                <br/>
                <Services username={username} services={services} stopService={stopService()}
                          addCopyOfInstance={addCopyOfInstance()} startService={startService()}/>
            </div>
        )
    }
}

const mapStateToProps = store => {
    return {
        username: store.username,
        services: store.services
    }
};
const mapDispatchToProps = dispatch => ({
    // logOut: (username) => dispatch(logOut(username)),
    addNewInstance: (type, git, username) => dispatch(addNewInstance(type, git, username)),
    getServices: () => dispatch(getServices()),
    stopService: (username, instanceId) => dispatch(stopService(username, instanceId)),
    addCopyOfInstance: (username, instanceId) => dispatch(addCopyOfInstance(username, instanceId)),
    startService: (username, instanceId) => dispatch(startService(username, instanceId))
});

export default connect(mapStateToProps, mapDispatchToProps)(Profile);
