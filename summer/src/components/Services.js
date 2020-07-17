import {Component} from 'react';
import React from "react";

export default class Services extends Component {
    render() {
        const {stopService, addCopyOfInstance, startService, username, deleteService, services} = this.props;
        const {serv} = services.map((service, index) =>
            <div key={index}>
                <tr>
                    <td>{service.name}</td>
                    <td>{service.url}</td>
                    <td>{service.status}</td>
                    <td>
                        <button className={'btn'} onClick={() => addCopyOfInstance(username)}>Add copy</button>
                    </td>
                    {service.status === 'active' ?
                        <td>
                            <button className={'btn'} style={{color: 'darkred'}}
                                    onClick={() => stopService(username)}>Stop
                            </button>
                        </td>
                        :
                        <td>
                            < button className={'btn'} style={{color: 'green'}}
                                     onClick={() => startService(username)}>Start
                            </button>
                        </td>}
                    <td>
                        <button className={'btn'} onClick={() => deleteService(username)}>Delete</button>
                    </td>
                </tr>
            </div>);
        return (
            <div>
                <table className={'table'}>
                    <tbody>
                    <tr>Your active services:</tr>
                    <br/>
                    <tr>
                        <td>Microservice name</td>
                        <td>URL</td>
                        <td>Status</td>
                    </tr>
                    {serv}
                    </tbody>
                </table>
            </div>
        );
    }
}

