import {Component} from 'react';
import React from "react";
import './index.css';
import {Link} from "react-router-dom";

let BaseScor = 0;
let TemporalScor = 0;
let Env = 0;

class v2 extends Component {
    constructor(props) {
        super(props);
        this.state = {
            AV: null,
            AC: null,
            Au: null,
            C: null,
            I: null,
            A: null,
            BaseScore: null,
            E: null,
            RL: null,
            RC: null,
            TemporalScore: null,
            CDP: null,
            TD: null,
            CR: null,
            IR: null,
            AR: null,
            EnvScore: null
        }
    }


    componentDidUpdate(prevProps, prevState, snapshot) {
        let FIMPACT = 1.176;
        const {AC, AV, Au, I, A, C, E, RL, RC, CDP, TD, CR, IR, AR} = this.state;
        if (A && AV && AC && Au && I && C) {
            let Expl = 20 * AV * AC * Au;
            let Impact = 10.41 * (1 - (1 - C) * (1 - I) * (1 - A));
            if (Impact === FIMPACT) {
                FIMPACT = 0;
            }
            BaseScor = (((0.6 * Impact) + (0.4 * Expl) - 1.5) * FIMPACT).toFixed(1);
            const {BaseScore} = this.state;
            if (BaseScore && E && RL && RC) {
                TemporalScor = (BaseScore * E * RL * RC).toFixed(1);
            }
            const {TemporalScore} = this.state;
            if (TemporalScore && CDP && AR && IR && CR && TD) {
                let AdImp = Math.min(10, 10.41 * (1 - (1 - C * CR) * (1 - I * IR) * (A * AR)));
                let ABaseScore = (((0.6 * AdImp) + (0.4 * Expl) - 1.5) * FIMPACT);
                let ATemp = ABaseScore * E * RL * RC;
                Env = ((ATemp + (10 - ATemp) * CDP) * TD).toFixed(1);
            }
        }

    }

    kk = () => {
        if (BaseScor !== 0) {
            this.setState({BaseScore: BaseScor});
        }
        if (BaseScor >= 9 && BaseScor <= 10) {
            alert("Критический");
        } else if (BaseScor >= 7 && BaseScor <= 8.9) {
            alert("Высокий");
        } else if (BaseScor >= 4 && BaseScor <= 6.9) {
            alert("Средний");
        } else if (BaseScor >= 0.1 && BaseScor <= 3.9) {
            alert("Низкий");
        } else if (BaseScor === 0) {
            alert("Информационный");
        }
    };
    temp = () => {
        if (TemporalScor !== 0) {
            this.setState({TemporalScore: TemporalScor})
        }
        if (TemporalScor >= 9 && TemporalScor <= 10) {
            alert("Критический");
        } else if (TemporalScor >= 7 && TemporalScor <= 8.9) {
            alert("Высокий");
        } else if (TemporalScor >= 4 && TemporalScor <= 6.9) {
            alert("Средний");
        } else if (TemporalScor >= 0.1 && TemporalScor <= 3.9) {
            alert("Низкий");
        } else if (TemporalScor === 0) {
            alert("Информационный");
        }
    };
    env = () => {
        if (Env !== 0) {
            this.setState({EnvScore: Env})
        }
        if (Env >= 9 && Env <= 10) {
            alert("Критический");
        } else if (Env >= 7 && Env <= 8.9) {
            alert("Высокий");
        } else if (Env >= 4 && Env <= 6.9) {
            alert("Средний");
        } else if (Env >= 0.1 && Env <= 3.9) {
            alert("Низкий");
        } else if (Env === 0) {
            alert("Информационный");
        }
    };

    componentDidMount() {
        this.ff();
    }

    ff() {
        document.getElementById('AV').onclick = (event) => {
            this.setState({AV: event.target.value});
        };
        document.getElementById('AC').onclick = (event) => {
            this.setState({AC: event.target.value});
        };
        document.getElementById('Au').onclick = (event) => {
            this.setState({Au: event.target.value});
        };
        document.getElementById('I').onclick = (event) => {
            this.setState({I: event.target.value});
        };
        document.getElementById('C').onclick = (event) => {
            this.setState({C: event.target.value});
        };
        document.getElementById('A').onclick = (event) => {
            this.setState({A: event.target.value});
        };
        document.getElementById('E').onclick = (event) => {
            this.setState({E: event.target.value});
        };
        document.getElementById('RL').onclick = (event) => {
            this.setState({RL: event.target.value});
        };
        document.getElementById('RC').onclick = (event) => {
            this.setState({RC: event.target.value});
        };
        document.getElementById('CDP').onclick = (event) => {
            this.setState({CDP: event.target.value});
        };
        document.getElementById('TD').onclick = (event) => {
            this.setState({TD: event.target.value});
        };
        document.getElementById('CR').onclick = (event) => {
            this.setState({CR: event.target.value});
        };
        document.getElementById('IR').onclick = (event) => {
            this.setState({IR: event.target.value});
        };
        document.getElementById('AR').onclick = (event) => {
            this.setState({AR: event.target.value});
        };

    }


    openClose = (event) => {
        // let target = document.getElementById(event.target.className);
        // if (target !== null) {
        //     if (target.style.display === "block") {
        //         target.style.display = "none";
        //     } else if (target.style.display === "none") {
        //         target.style.display = "block";
        //     }
        // }
    };

    render() {
        const {BaseScore, TemporalScore, EnvScore} = this.state;
        let disp = {
            display: 'none'
        };
        return (
            <div>
                <Link to={'/v3'}>Go to v3</Link>
                <br/>
                <h1>CVSS v2</h1>
                <br/>
                <h3>Базовая оценка: {BaseScore}</h3>
                <button onClick={(event) => this.openClose(event)}><h2 className={"Base"}>Базовые метрики:</h2></button>
                <br/>
                <br/>
                <br/>
                <div id={"Base"}>
                    <label>Вектор атаки(AV):</label>
                    <table>
                        <tbody>
                        <tr className={'AV'} id={'AV'}>
                            <td>
                                <input type='radio' id='radio-1' value={0.395} name={"av"}/>
                                <label htmlFor={"radio-1"}>Локальный(L) </label>
                            </td>
                            <td>
                                <input type='radio' id='radio-2' value={0.646} name={"av"}/>
                                <label htmlFor={"radio-2"}>Смежная сеть(A) </label>
                            </td>
                            <td>
                                <input type='radio' id='radio-3' value={1.0} name={"av"}/>
                                <label htmlFor={"radio-3"}>Сетевой(L)</label>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <br/>
                    <label>Сложность получения доступа(AC):</label>
                    <table>
                        <tbody>
                        <tr className={'AC'} id={'AC'}>
                            <td>
                                <input type='radio' id={'rad-1'} value={0.35} name={'ac'}/>
                                <label htmlFor={'rad-1'}>Высокая(H) </label>
                            </td>
                            <td>
                                <input type='radio' id={'rad-2'} value={0.61} name={'ac'}/>
                                <label htmlFor={'rad-2'}>Средняя(M) </label>
                            </td>
                            <td>
                                <input type='radio' id={'rad-3'} value={0.71} name={'ac'}/>
                                <label htmlFor={'rad-3'}>Низкая(L) </label>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <br/>
                    <label>Аутентификация(Au):</label>
                    <table>
                        <tbody>
                        <tr className={'Au'} id={'Au'}>
                            <td>
                                <input type='radio' id={'radi-1'} value={0.45} name={'au'}/>
                                <label htmlFor={'radi-1'}>Множественная(M) </label>
                            </td>
                            <td>
                                <input type='radio' id={'radi-2'} value={0.56} name={'au'}/>
                                <label htmlFor={'radi-2'}>Единственная(S)</label>
                            </td>
                            <td>
                                <input type='radio' id={'radi-3'} value={0.704} name={'au'}/>
                                <label htmlFor={'radi-3'}>Не требуется(N)</label>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <br/>
                    <label>Влияние на конф.(C):</label>
                    <table>
                        <tbody>
                        <tr className={'C'} id={'C'}>
                            <td>
                                <input type='radio' id={'radii-1'} value={0.0} name={'c'}/>
                                <label htmlFor={'radii-1'}>Не оказывает(N)</label>
                            </td>
                            <td>
                                <input type='radio' id={'radii-2'} value={0.275} name={'c'}/>
                                <label htmlFor={'radii-2'}>Частное(P)</label>
                            </td>
                            <td>
                                <input type='radio' id={'radii-3'} value={0.66} name={'c'}/>
                                <label htmlFor={'radii-3'}>Полное(C)</label>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <br/>
                    <label>Влияние на целостность(I):</label>
                    <table>
                        <tbody>
                        <tr className={'I'} id={'I'}>
                            <td>
                                <input type='radio' id={'radii-9'} value={0.0} name={'i'}/>
                                <label htmlFor={'radii-9'}>Не оказывает(N)</label>
                            </td>
                            <td>
                                <input type='radio' id={'radii-8'} value={0.275} name={'i'}/>
                                <label htmlFor={'radii-8'}>Частное(P)</label>
                            </td>
                            <td>
                                <input type='radio' id={'radii-7'} value={0.66} name={'i'}/>
                                <label htmlFor={'radii-7'}>Полное(C)</label>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <br/>
                    <label>Влияние на доступность(A):</label>
                    <table>
                        <tbody>
                        <tr className={'A'} id={'A'}>
                            <td>
                                <input type='radio' id={'radii-4'} value={0.0} name={'a'}/>
                                <label htmlFor={'radii-4'}>Не оказывает(N)</label>
                            </td>
                            <td>
                                <input type='radio' id={'radii-5'} value={0.275} name={'a'}/>
                                <label htmlFor={'radii-5'}>Частное(P)</label>
                            </td>
                            <td>
                                <input type='radio' id={'radii-6'} value={0.66} name={'a'}/>
                                <label htmlFor={'radii-6'}>Полное(C)</label>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <br/>
                    <button onClick={() => this.kk()}>Подсчет результа</button>
                </div>
                <br/>
                <h3>Временная оценка: {TemporalScore}</h3>
                <br/>
                <button onClick={(event) => this.openClose(event)}><h2 className={"Temporal"}>Временные метрики:</h2>
                </button>
                <br/>
                <br/>
                <br/>
                <div id={"Temporal"}>
                    <label>Возможность использования(E):</label>
                    <table>
                        <tbody>
                        <tr className={'E'} id={'E'}>
                            <td>
                                <input type='radio' id='radio-11' value={1.0} name={"e"}/>
                                <label htmlFor={"radio-11"}>Не определено(ND) </label>
                            </td>
                            <td>
                                <input type='radio' id='radio-12' value={0.85} name={"e"}/>
                                <label htmlFor={"radio-12"}>Теоретически(U) </label>
                            </td>
                            <td>
                                <input type='radio' id='radio-13' value={0.9} name={"e"}/>
                                <label htmlFor={"radio-13"}>Есть концепция(POC)</label>
                            </td>
                            <td>
                                <input type='radio' id='radio-14' value={0.95} name={"e"}/>
                                <label htmlFor={"radio-14"}>Есть сценарий(F)</label>
                            </td>
                            <td>
                                <input type='radio' id='radio-15' value={1.0} name={"e"}/>
                                <label htmlFor={"radio-15"}>Высокая(H)</label>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <label>Уровень исправления(RL):</label>
                    <table>
                        <tbody>
                        <tr className={'RL'} id={'RL'}>
                            <td>
                                <input type='radio' id='radio-16' value={1.0} name={"rl"}/>
                                <label htmlFor={"radio-16"}>Не определено(ND) </label>
                            </td>
                            <td>
                                <input type='radio' id='radio-17' value={0.87} name={"rl"}/>
                                <label htmlFor={"radio-17"}>Официальное(OF) </label>
                            </td>
                            <td>
                                <input type='radio' id='radio-18' value={0.9} name={"rl"}/>
                                <label htmlFor={"radio-18"}>Временное(T)</label>
                            </td>
                            <td>
                                <input type='radio' id='radio-19' value={0.95} name={"rl"}/>
                                <label htmlFor={"radio-19"}>Рекомендации(W)</label>
                            </td>
                            <td>
                                <input type='radio' id='radio-20' value={1.0} name={"rl"}/>
                                <label htmlFor={"radio-20"}>Недоступно(U)</label>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <label>Уровень исправления(Rc):</label>
                    <table>
                        <tbody>
                        <tr className={'RC'} id={'RC'}>
                            <td>
                                <input type='radio' id='radio-21' value={1.0} name={"rc"}/>
                                <label htmlFor={"radio-21"}>Не определено(ND) </label>
                            </td>
                            <td>
                                <input type='radio' id='radio-22' value={0.9} name={"rc"}/>
                                <label htmlFor={"radio-22"}>Не подтверждена(UC) </label>
                            </td>
                            <td>
                                <input type='radio' id='radio-23' value={0.95} name={"rc"}/>
                                <label htmlFor={"radio-23"}>Не доказана(UR)</label>
                            </td>
                            <td>
                                <input type='radio' id='radio-24' value={1.0} name={"rc"}/>
                                <label htmlFor={"radio-24"}>Подтверждена(C)</label>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <br/>
                    <button onClick={(event) => this.temp(event)}>Подсчитать</button>
                </div>
                <br/>
                <h3> Контекстная оценка: {EnvScore}</h3>
                <br/>
                <button onClick={(event) => this.openClose(event)}><h2 className={"Environmental"}>Контекстные
                    метрики:</h2></button>
                <br/>
                <br/>
                <br/>
                <div id={"Environmental"}>
                    <label>Возможность использования(E):</label>
                    <table>
                        <tbody>
                        <tr className={'CDP'} id={'CDP'}>
                            <td>
                                <input type='radio' id='radioi-11' value={0.0} name={"cdp"}/>
                                <label htmlFor={"radioi-11"}>Не определено(ND) </label>
                            </td>
                            <td>
                                <input type='radio' id='radioi-12' value={0.0} name={"cdp"}/>
                                <label htmlFor={"radioi-12"}>Отсутствует(N) </label>
                            </td>
                            <td>
                                <input type='radio' id='radioi-13' value={0.1} name={"cdp"}/>
                                <label htmlFor={"radioi-13"}>Низкая(L)</label>
                            </td>
                            <td>
                                <input type='radio' id='radioi-14' value={0.3} name={"cdp"}/>
                                <label htmlFor={"radioi-14"}>Средняя(LM)</label>
                            </td>
                            <td>
                                <input type='radio' id='radioi-15' value={0.4} name={"cdp"}/>
                                <label htmlFor={"radioi-15"}>Повышенная(MH)</label>
                            </td>
                            <td>
                                <input type='radio' id='radioi-35' value={0.5} name={"cdp"}/>
                                <label htmlFor={"radioi-35"}>Высокая(H)</label>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <label>Уровень исправления(TD):</label>
                    <table>
                        <tbody>
                        <tr className={'TD'} id={'TD'}>
                            <td>
                                <input type='radio' id='radioi-16' value={1.0} name={"td"}/>
                                <label htmlFor={"radioi-16"}>Не определено(ND) </label>
                            </td>
                            <td>
                                <input type='radio' id='radioi-17' value={0.0} name={"td"}/>
                                <label htmlFor={"radioi-17"}>Отсутствует(N) </label>
                            </td>
                            <td>
                                <input type='radio' id='radioi-18' value={0.25} name={"td"}/>
                                <label htmlFor={"radioi-18"}>Низкая(L)</label>
                            </td>
                            <td>
                                <input type='radio' id='radioi-19' value={0.75} name={"td"}/>
                                <label htmlFor={"radioi-19"}>Средняя(LM)</label>
                            </td>
                            <td>
                                <input type='radio' id='radioi-20' value={1.0} name={"td"}/>
                                <label htmlFor={"radioi-20"}>Высокая(H)</label>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <label>Требования к конфиденциальности(CR):</label>
                    <table>
                        <tbody>
                        <tr className={'CR'} id={'CR'}>
                            <td>
                                <input type='radio' id='radiol-21' value={1.0} name={"cr"}/>
                                <label htmlFor={"radiol-21"}>Не определено(ND) </label>
                            </td>
                            <td>
                                <input type='radio' id='radiol-22' value={0.5} name={"cr"}/>
                                <label htmlFor={"radiol-22"}>Низкая(L </label>
                            </td>
                            <td>
                                <input type='radio' id='radiol-23' value={1.0} name={"cr"}/>
                                <label htmlFor={"radiol-23"}>Средняя(LM)</label>
                            </td>
                            <td>
                                <input type='radio' id='radiol-24' value={1.51} name={"cr"}/>
                                <label htmlFor={"radiol-24"}>Высокая(H)</label>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <label>Требования к целостности(IR):</label>
                    <table>
                        <tbody>
                        <tr className={'IR'} id={'IR'}>
                            <td>
                                <input type='radio' id='radiok-21' value={1.0} name={"ir"}/>
                                <label htmlFor={"radiok-21"}>Не определено(ND) </label>
                            </td>
                            <td>
                                <input type='radio' id='radiok-22' value={0.5} name={"ir"}/>
                                <label htmlFor={"radiok-22"}>Низкая(L </label>
                            </td>
                            <td>
                                <input type='radio' id='radiok-23' value={1.0} name={"ir"}/>
                                <label htmlFor={"radiok-23"}>Средняя(LM)</label>
                            </td>
                            <td>
                                <input type='radio' id='radiok-24' value={1.51} name={"ir"}/>
                                <label htmlFor={"radiok-24"}>Высокая(H)</label>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <label>Требования к доступности(AR):</label>
                    <table>
                        <tbody>
                        <tr className={'AR'} id={'AR'}>
                            <td>
                                <input type='radio' id='radiokl-21' value={1.0} name={"ar"}/>
                                <label htmlFor={"radiokl-21"}>Не определено(ND) </label>
                            </td>
                            <td>
                                <input type='radio' id='radiokl-22' value={0.5} name={"ar"}/>
                                <label htmlFor={"radiokl-22"}>Низкая(L </label>
                            </td>
                            <td>
                                <input type='radio' id='radiokl-23' value={1.0} name={"ar"}/>
                                <label htmlFor={"radiokl-23"}>Средняя(LM)</label>
                            </td>
                            <td>
                                <input type='radio' id='radiokl-24' value={1.51} name={"ar"}/>
                                <label htmlFor={"radiokl-24"}>Высокая(H)</label>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <br/>
                    <button onClick={(event) => this.env(event)}>Подсчитать</button>
                </div>
                <br/>
                <br/>
                <br/>
            </div>);
    }
}

export default v2;

