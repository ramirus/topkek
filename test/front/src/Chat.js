import {Component} from 'react';
import {Link} from "react-router-dom";
import React from "react";

class Chat extends Component {
    constructor(props) {
        super(props);
        this.state = {
            user: '',
            messages: [],
            onlineUsers: [],
            currentMes: ''
        }
    }

    componentDidMount() {
        fetch(`/chat/${this.props.match.params.user}`)
            .then(response => {
                return response.json();
            })
            .then(data => {
                this.setState({
                    user: this.props.match.params.user,
                    messages: data.messageDtoList,
                    onlineUsers: data.onlineUserList
                });
            })
            .catch(error => {
                alert("Error: " + error)
            })
    }

    logout = () => {
        fetch(`/chat/${this.props.match.params.user}`, {
            method: 'delete',
            headers: {
                "Accept": "application/json",
                "Content-type": "application/json; charset=UTF-8"
            }
        });
    };

    send = (user, text) => {
        let data = {
            user: user,
            message: text
        };
        let arr = this.state.messages;
        let d = arr.push(data);
        console.log(data);
        this.setState({messages: arr});
        document.location.reload();
        fetch(`/chat/${this.props.match.params.user}`, {
            method: 'post',
            headers: {
                "Accept": "application/json",
                "Content-type": "application/json; charset=UTF-8"
            },
            body: JSON.stringify(data)
        });
    };

    render() {
        const {messages} = this.state;
        const {onlineUsers} = this.state;
        const mes = messages.map((message, index) =>
            <div key={index}>
                <ul>
                    <br/>
                    <li>{message.user}:{message.message}</li>
                </ul>
            </div>
        );
        const online = onlineUsers.map((name, index) =>
            <div key={index}>
                <ul>
                    <li>{name}</li>
                    <br/>
                </ul>
            </div>);
        return (<div>
            <h1>Chat</h1>
            <h2>Online users :</h2>
            <div>{online}</div>
            <Link onClick={this.logout} to={"/login"}>Quit</Link>
            <br/>
            <input name={"message"} id={"mes"}
                   onChange={(event) => this.setState({currentMes: event.target.value})}/>
            <button onClick={() => this.send(this.state.user, this.state.currentMes)}> Send</button>
            <h2>Messages:</h2>
            <div>{mes}</div>
        </div>);
    }


}

export default Chat;