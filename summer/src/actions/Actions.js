import axios from 'axios';
import {
    ADD_COPY_INSTANCE,
    ADD_INSTANCE,
    ERROR,
    LOGOUT,
    START_SERVICE,
    STOP_INSTANCE,
    SUCCESS,
    SUCCESS_AUTH
} from "../types/types";


export const logIn = (username, password) => {
    let data = {
        username: username,
        password: password
    };
    return dispatch => {
        axios.post(`/login`, data)
            .then(() => {
                dispatch(SuccessAuth(data))
            })
            .catch((error) => {
                dispatch(Error(error))
            });
    };
};

// export const logOut = (data) => {
//     return {
//         type:LOGOUT,
//         payload:{
//             ...data
//         }
//     }
// };

export const getServices = () => {
    return dispatch => {
        axios.get(`/profile`)
            .then(response => {
                dispatch(SuccessActive(response.data));
            })
            .catch(error => {
                dispatch(Error(error.message))
            });
    };
};

export const addCopyOfInstance = (username, instanceId) => {
    let data = {
        username: username,
        instanceId: instanceId
    };
    return dispatch => {
        axios.post(`/`, data)
            .then((response) => {
                dispatch(copyOfInstance(response.data))
            })
            .catch(error => {
                dispatch(Error(error.message));
            });
    };
};
export const addNewInstance = (type, git, username) => {
    let data = {
        type: type,
        git: git,
        username: username
    };
    return dispatch => {
        axios.post(`/`, data)
            .then((response) => {
                dispatch(newInstance(response.data))
            })
            .catch((error) => {
                dispatch(Error(error.message));
            });
    };
};
export const stopService = (username, instanceId) => {
    let data = {
        username: username, instanceId: instanceId
    };
    return dispatch => {
        axios.post(`/`, data)
            .then(() => {
                dispatch(stopServ(data))
            })
            .catch((error) => {
                dispatch(Error(error.message));
            });
    }
};
export const startService = (username, instanceId) => {
    let data = {
        username: username, instanceId: instanceId
    };
    return dispatch => {
        axios.post(`/`, data)
            .then(() => {
                dispatch(startServ(data))
            })
            .catch((error) => {
                dispatch(Error(error.message));
            });
    }
};
export const startServ = (data) => {
    return {
        type: START_SERVICE,
        payload: {
            ...data
        }
    }
};
export const copyOfInstance = (data) => {
    return {
        type: ADD_COPY_INSTANCE,
        payload: {
            ...data
        }
    }
};
export const newInstance = (data) => {
    return {
        type: ADD_INSTANCE,
        payload: {
            ...data
        }
    }
};
export const stopServ = (data) => {
    return {
        type: STOP_INSTANCE,
        payload: {
            ...data
        }
    }
};
export const SuccessAuth = (data) => {
    return {
        type: SUCCESS_AUTH,
        payload: {
            ...data
        }
    }
};
export const SuccessActive = (data) => {
    return {
        type: SUCCESS,
        payload: {
            ...data
        }
    }
};

export const Error = (error) => {
    return {
        type: ERROR,
        payload: {error}
    };
};
