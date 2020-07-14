import {
    ADD_COPY_INSTANCE,
    ADD_INSTANCE,
    ERROR,
    START_SERVICE,
    STOP_INSTANCE,
    SUCCESS,
    SUCCESS_AUTH
} from "../types/types";

export const State = {
    username: null,
    services: [],
    error: null
};

export function reducer(state = State, action) {
    switch (action.type) {
        case ADD_COPY_INSTANCE: {
            return {
                ...state,
                services: [...state.services, action.payload]
            }
        }
        case  ADD_INSTANCE: {
            return {
                ...state,
                services: [...state.services, action.payload]
            }
        }
        case START_SERVICE : {
            for (let i = 0; i < state.services.length; i++) {
                if (state.services[i].instanceId === action.payload.services.instanceId) {
                    state.services[i].status = 'active';
                }
            }
            return {
                ...state,
                services: [...state.services]
            }
        }
        case STOP_INSTANCE: {
            for (let i = 0; i < state.services.length; i++) {
                if (state.services[i].instanceId === action.payload.services.instanceId) {
                    state.services[i].status = 'not active';
                }
            }
            return {
                ...state,
                services: [...state.services]
            }
        }
        case SUCCESS_AUTH: {
            return {
                ...state,
                username: action.payload.username
            }
        }
        case SUCCESS: {
            return {
                ...state,
                services: action.payload.services
            }
        }
        case ERROR: {
            return {
                ...state,
                error: action.payload.error
            };
        }
        default: {
            return state;
        }
    }
}
