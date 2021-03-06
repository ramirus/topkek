import axios from 'axios';
import {
    ADD_COPY_INSTANCE,
    ADD_INSTANCE, DELETE_SERVICE,
    ERROR,
    LOGOUT,
    START_SERVICE,
    STOP_INSTANCE,
    SUCCESS,
    SUCCESS_AUTH
} from "../types/types";


export const logIn = (username, password) => {
    let data = {
        login: username,
        password: password
    };
    return dispatch => {
        axios.post(`/login`, data)
            .then((response) => {
                data.token = response.data;
                dispatch(SuccessAuth(data))
            })
            .catch((error) => {
                dispatch(Error(error))
            });
    };
};

export const getServices = (username) => {
    return dispatch => {
        axios.get(`/applications/${username}`)
            .then(response => {
                dispatch(SuccessActive(response.data));
            })
            .catch(error => {
                dispatch(Error(error.message))
            });
    };
};

export const addCopyOfInstance = (data) => {

    return dispatch => {
        axios.post(`/api/application`, data)
            .then((response) => {
                dispatch(copyOfInstance(response.data))
            })
            .catch(error => {
                dispatch(Error(error.message));
            });
    };
};
export const addNewInstance = (git, username) => {
    let data = {
        gitUrl: git,
        ownerName: username
    };
    return dispatch => {
        axios.post(`/api/application`, data)
            .then((response) => {
                dispatch(newInstance(response.data))
            })
            .catch((error) => {
                dispatch(Error(error.message));
            });
    };
};
export const deleteService = (instanceId) => {
    let data = {
        instanceId: instanceId
    }
    return dispatch => {
        axios.delete(`/applications/${instanceId}`)
            .then(() => {
                dispatch(deleteServ(data))
            })
            .catch((error) => {
                dispatch(Error(error.message));
            });
    };
};
export const stopService = (instanceId) => {
    let data = {
        instanceId: instanceId
    };
    return dispatch => {
        axios.put(`/applications/stop/${instanceId}`)
            .then(() => {
                dispatch(stopServ(data))
            })
            .catch((error) => {
                dispatch(Error(error.message));
            });
    };
};
export const startService = (instanceId) => {
    let data = {
        instanceId: instanceId
    };
    return dispatch => {
        axios.put(`/applications/start/${instanceId}`)
            .then(() => {
                dispatch(startServ(data))
            })
            .catch((error) => {
                dispatch(Error(error.message));
            });
    }
};

export const deleteServ=(data)=>{
    return{
        type:DELETE_SERVICE,
        payload:{
            ...data
        }
    }
}
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
export const SuccessAuth = (data, token) => {
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
