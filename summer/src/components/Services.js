import {Component} from 'react';
import React from "react";

export default class Services extends Component {
    render() {
        const {stopService, addCopyOfInstance, startService, username} = this.props;
        const {services} = this.props.services.map((service, index) =>
            <div key={index}>
                <tr>
                    <td>{service.name}</td>
                    <td>{service.url}</td>
                    <td>{service.status}</td>
                    <td>
                        <button onClick={() => addCopyOfInstance(username, service.instanceId)}>Add copy</button>
                        {service.status === 'active' ?
                            <button onClick={() => stopService(username, service.instanceId)}>Stop</button>
                            : < button onClick={() => startService(username, service.instanceId)}>Start</button>
                        }
                    </td>
                </tr>
            </div>);
        return (
            <div>
                <table>
                    <tr>
                        <th>Microservice</th>
                        <th>Status</th>
                    </tr>
                    {services}
                </table>
            </div>
        );
    }
}


