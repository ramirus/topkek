import React, {Component} from 'react';
import Services from '../components/Services.js';
import {connect} from "react-redux";
import {Link} from "react-router-dom";
import '../css/profile.css';
import {
    addCopyOfInstance,
    addNewInstance,
    deleteService,
    getServices,
    startService,
    stopService
} from "../actions/Actions";

class Profile extends Component {
    constructor(props) {
        super(props);
        this.state = {
            type: null,
            github: null
        }
    }

    componentDidMount() {
        if (this.props.username === null) {
            this.props.history.push(`/login`);
        }
        const {getServices} = this.props;
        getServices(this.props.username);
    }

    render() {
        const {stopService, username, addNewInstance, services, addCopyOfInstance, startService,deleteService} = this.props;
        return (
            <div>
                <div>
                    <Link className={'btn'} to='/login/'>Exit</Link>
                    <Link  className={'btn'} to='/signUp/'>Registration</Link>
                </div>
                <br/>
                <form className={'newInstanceWin'}>
                    <label>GitHub link </label>
                    <input className={'text-input'} style={{height:'25px', width:'400px', margin:'5px 5px '}} required={true} onChange={(event) => this.setState({github: event.target.value})}
                           type={"text"}
                           name={'project-link'} id={'project-link'}/>
                    {/*<label>Select microservice type</label>*/}
                    {/*<select required={true} size={"1"} name={"type"} id={"type"}*/}
                            {/*onChange={(event) => this.setState({type: event.target.value})}>*/}
                        {/*<option value={"Java"}>Java</option>*/}
                        {/*<option value={"Javascript"}>Javascript</option>*/}
                        {/*<option value={"Postgres"}>Postgres</option>*/}
                        {/*<option value={"Rabbit"}>Rabbit</option>*/}
                        {/*<option value={"Redis"}>Redis</option>*/}
                    {/*</select>*/}
                    {/*<br/>*/}
                    <button className={'btn'} style={{width:'200px'}} onClick={() => addNewInstance( this.state.github, username)}>Add new
                        app
                    </button>
                </form>
                <br/>
                <Services username={username} services={services} stopService={stopService()}
                          addCopyOfInstance={addCopyOfInstance()} startService={startService()} deleteService={deleteService()}/>
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
    addNewInstance: (git, username) => dispatch(addNewInstance(git, username)),
    getServices: (username) => dispatch(getServices(username)),
    stopService: (instanceId) => dispatch(stopService(instanceId)),
    addCopyOfInstance: (instance) => dispatch(addCopyOfInstance(instance)),
    startService: (instanceId) => dispatch(startService(instanceId)),
    deleteService:(instanceId)=>dispatch(deleteService(instanceId))
});

export default connect(mapStateToProps, mapDispatchToProps)(Profile);
