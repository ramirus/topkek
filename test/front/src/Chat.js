import {Component} from 'react';
import {Link} from "react-router-dom";
import React from "react";
import {connect} from "react-redux";
import {updateMessages} from "./actions/chatAction";
import OnlineUsers from "./containers/onlineUsers"
import Messages from "./containers/messages";
import axios from 'axios';

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
            axios.get(`/chat/${this.props.match.params.user}`)
                .then(response => {
                    console.log(response.data);
                    this.setState({
                        user: this.props.match.params.user,
                        messages: response.data.messageDtoList,
                        onlineUsers: response.data.onlineUserList
                    });
                })
                .catch(error => {
                    alert("Error: " + error)
                });
        }


    logout = () => {
        // fetch(`/chat/${this.props.match.params.user}`, {
        //     method: 'delete',
        //     headers: {
        //         "Accept": "application/json",
        //         "Content-type": "application/json; charset=UTF-8"
        //     }
        // });
        axios.delete(`/chat/${this.props.match.params.user}`)
            .catch((err) => {
                console.log(err);
            });;
    };

    send = (user, text) => {
        let data = {
            user: user,
            message: text
        };
        let arr = this.state.messages;
        let d = arr.push(data);
        this.setState({messages: arr});
        // fetch(`/chat/${this.props.match.params.user}`, {
        //     method: 'post',
        //     headers: {
        //         "Accept": "application/json",
        //         "Content-type": "application/json; charset=UTF-8"
        //     },
        //     body: JSON.stringify(data)
        // });
        axios.post(`/chat/${this.props.match.params.user}`, data)
            .then((res) => {
                console.log(res.data);
            })
            .catch((err) => {
                console.log(err);
            });

        this.props.updateMessages(arr);
    };

    render() {
        const {updateMessages} = this.props;
        const {messages} = this.state;
        const {onlineUsers} = this.state;
        return (
            <div>
                <h1>Chat</h1>
                <h1>{this.props.activeUsers}</h1>
                <h2>Online users :</h2>
                <OnlineUsers users={onlineUsers}/>
                <Link onClick={this.logout} to={"/login"}>Quit</Link>
                <br/>
                <input name={"message"} id={"mes"}
                       onChange={(event) => this.setState({currentMes: event.target.value})}/>
                <button onClick={() => this.send(this.state.user, this.state.currentMes)}> Send</button>
                <h2>Messages:</h2>
                <Messages mes={messages} updateMessages={updateMessages}/>
            </div>);
    }


}

const mapDispatchToProps = dispatch => ({
    updateMessages: messages => dispatch(updateMessages(messages))
});

const mapStateToProps = store => {
    console.log(store);
    return {
        messages: store.messages,
        activeUsers: store.activeUsers
    }
};

export default connect(mapStateToProps, mapDispatchToProps)(Chat);

// export default Chat;