import {Component} from 'react';
import React from "react";
import {Link} from "react-router-dom";

let BaseScor = 1, Env = 0, TemporalScor = 0;

class v3 extends Component {
    constructor(props) {
        super(props);
        this.state = {
            AV: null,
            AC: null,
            UI: null,
            C: null,
            S: null,
            I: null,
            A: null,
            PR: null,
            BaseScore: null,
            E: null,
            RL: null,
            RC: null,
            TemporalScore: null,
            CR: null,
            IR: null,
            AR: null,
            MAV: null,
            MAC: null,
            MPR: null,
            MUI: null,
            MS: null,
            MC: null,
            MI: null,
            MA: null,
            EnvScore: null
        }
    }

    componentDidUpdate(prevProps, prevState, snapshot) {

        const {C, I, A, AV, AC, PR, UI, S} = this.state;
        if (C && I && A && AV && AC && PR && UI && S) {
            let Impact = 0, Expl = 8.22 * AV * AC * PR * UI, ImpactBase = 1 - ((1 - C) * (1 - I) * (1 - A));
            console.log(S);
            if (S == 0) {
                Impact = 6.42 * ImpactBase;
            } else if (S === 1) {
                Impact = 7.52 * (ImpactBase - 0.029) - 3.25 * ((ImpactBase - 0.02) ** 15);
            }
            if (Impact <= 0) {
                BaseScor = 0;
            }
            if (S == 0) {
                BaseScor = (Math.min((Impact + Expl), 10)).toFixed(1);
            }
            if (S == 1) {
                BaseScor = (Math.min((1.08 * (Impact + Expl))), 10).toFixed(1);
            }
            console.log(this.state);
            const {BaseScore, E, RL, RC} = this.state;
            if (BaseScore && E && RL && RC) {
                TemporalScor = (BaseScore * E * RL * RC).toFixed(1);
            }
            const {TemporalScore, MAV, MAC, MPR, MUI, MS, MC, MA, MI, CR, IR, AR} = this.state;
            if (TemporalScore && MAV && MAC && MPR && MUI && MS && MC && MA && MI && CR && IR && AR) {

                let mImpact = 0;
                let mExpl = 8.22 * MAV * MAC * MPR * MUI;
                let mImpBase = Math.min((1 - (1 - MC * CR) * (1 - MI * IR) * (1 - MA * AR)), 0.915);
                if (mImpact <= 0) {
                    Env = 0;
                }
                if (MS == 0) {
                    mImpact = 6.42 * (mImpBase);
                    Env = ((Math.min((mImpact + mExpl), 10).toFixed(1)) * E * RL * RC).toFixed(1);
                } else if (MS == 1) {
                    mImpact = 7.52 * (mImpBase - 0.029) - 3.25 * ((mImpBase - 0.02) ** 15);
                    Env = ((Math.min(1.08 * (mImpact + mExpl), 10).toFixed(1)) * E * RL * RC).toFixed(1);
                }
            }
        }
    }

    componentDidMount() {
        this.onCl();
    }

    onCl = (event) => {
        document.getElementById('MAC').onclick = (event) => {
            this.setState({MAC: event.target.value});
        };
        document.getElementById('PR').onclick = (event) => {
            this.setState({PR: event.target.value});
        };
        document.getElementById('MAV').onclick = (event) => {
            this.setState({MAV: event.target.value});
        };
        document.getElementById('MPR').onclick = (event) => {
            this.setState({MPR: event.target.value});
        };
        document.getElementById('MUI').onclick = (event) => {
            this.setState({MUI: event.target.value});
        };
        document.getElementById('MS').onclick = (event) => {
            this.setState({MS: event.target.value});
        };
        document.getElementById('MC').onclick = (event) => {
            this.setState({MC: event.target.value});
        };
        document.getElementById('MI').onclick = (event) => {
            this.setState({MI: event.target.value});
        };
        document.getElementById('MA').onclick = (event) => {
            this.setState({MA: event.target.value});
        };
        document.getElementById('AV').onclick = (event) => {
            this.setState({AV: event.target.value});
        };
        document.getElementById('AC').onclick = (event) => {
            this.setState({AC: event.target.value});
        };
        document.getElementById('UI').onclick = (event) => {
            this.setState({UI: event.target.value});
        };
        document.getElementById('I').onclick = (event) => {
            this.setState({I: event.target.value});
        };
        document.getElementById('S').onclick = (event) => {
            this.setState({S: event.target.value});
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
        document.getElementById('CR').onclick = (event) => {
            this.setState({CR: event.target.value});
        };
        document.getElementById('IR').onclick = (event) => {
            this.setState({IR: event.target.value});
        };
        document.getElementById('AR').onclick = (event) => {
            this.setState({AR: event.target.value});
        };
    };

    kk = () => {
        console.log(BaseScor);
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

    openClose = (event) => {

    };

    render() {
        const {BaseScore, TemporalScore, EnvScore} = this.state;
        return (
            <div>
                <Link to={'/v2'}>Go to v2</Link>
                <br/>
                <h1>CVSS v3</h1>
                <br/>
                <div className={"BaseScore"}>
                    <h3>Базовая оценка: {BaseScore}</h3>
                    <button onClick={(event) => this.openClose(event)}><h2 className={"Base"}>Базовые метрики:</h2>
                    </button>
                    <br/>
                    <br/>
                    <br/>
                    <div id={"Base"}>
                        <label>Вектор атаки(AV):</label>
                        <table>
                            <tbody>
                            <tr className={'AV'} id={'AV'}>
                                <td>
                                    <input type='radio' id='radio-1' value={0.85} name={"av"}/>
                                    <label htmlFor={"radio-1"}>Физический(P) </label>
                                </td>
                                <td>
                                    <input type='radio' id='radiop-1' value={0.62} name={"av"}/>
                                    <label htmlFor={"radiop-1"}>Локальный(L) </label>
                                </td>
                                <td>
                                    <input type='radio' id='radio-2' value={0.55} name={"av"}/>
                                    <label htmlFor={"radio-2"}>Смежная сеть(A) </label>
                                </td>
                                <td>
                                    <input type='radio' id='radio-3' value={0.2} name={"av"}/>
                                    <label htmlFor={"radio-3"}>Сетевой(N)</label>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <br/>
                        <label>Сложность эксплуатации уязвимости(AC):</label>
                        <table>
                            <tbody>
                            <tr className={'AC'} id={'AC'}>
                                <td>
                                    <input type='radio' id={'rad-1'} value={0.77} name={'ac'}/>
                                    <label htmlFor={'rad-1'}>Высокая(H) </label>
                                </td>
                                <td>
                                    <input type='radio' id={'rad-3'} value={0.44} name={'ac'}/>
                                    <label htmlFor={'rad-3'}>Низкая(L) </label>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <br/>
                        <label>Уровень привилегий(PR):</label>
                        <table>
                            <tbody>
                            <tr className={'PR'} id={'PR'}>
                                <td>
                                    <input type='radio' id={'radi-1'} value={0.85} name={'pr'}/>
                                    <label htmlFor={'radi-1'}>Высокий(H) </label>
                                </td>
                                <td>
                                    <input type='radio' id={'radi-2'} value={this.state.S == 1 ? 0.68 : 0.62}
                                           name={'pr'}/>
                                    <label htmlFor={'radi-2'}>Низкий(L)</label>
                                </td>
                                <td>
                                    <input type='radio' id={'radi-3'} value={this.state.S == 1 ? 0.5 : 0.27}
                                           name={'pr'}/>
                                    <label htmlFor={'radi-3'}>None(N)</label>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <br/>
                        <label>Взаимодействие с пользователем(UI):</label>
                        <table>
                            <tbody>
                            <tr className={'UI'} id={'UI'}>
                                <td>
                                    <input type='radio' id={'radi-12'} value={0.85} name={'ui'}/>
                                    <label htmlFor={'radi-12'}>Не требуется(N) </label>
                                </td>
                                <td>
                                    <input type='radio' id={'radi-22'} value={0.62} name={'ui'}/>
                                    <label htmlFor={'radi-22'}>Требуется(R)</label>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <br/>
                        <label>Влияние на другие компоненты системы(S):</label>
                        <table>
                            <tbody>
                            <tr className={'S'} id={'S'}>
                                <td>
                                    <input type='radio' id={'radim-1'} value={0} name={'s'}/>
                                    <label htmlFor={'radim-1'}>Не оказывает(U) </label>
                                </td>
                                <td>
                                    <input type='radio' id={'radim-2'} value={1} name={'s'}/>
                                    <label htmlFor={'radim-2'}>Оказывает(C)</label>
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
                                    <input type='radio' id={'radii-2'} value={0.22} name={'c'}/>
                                    <label htmlFor={'radii-2'}>Low(L)</label>
                                </td>
                                <td>
                                    <input type='radio' id={'radii-3'} value={0.56} name={'c'}/>
                                    <label htmlFor={'radii-3'}>High(H)</label>
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
                                    <input type='radio' id={'radii-8'} value={0.22} name={'i'}/>
                                    <label htmlFor={'radii-8'}>Low(L)</label>
                                </td>
                                <td>
                                    <input type='radio' id={'radii-7'} value={0.56} name={'i'}/>
                                    <label htmlFor={'radii-7'}>High(H)</label>
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
                                    <input type='radio' id={'radii-5'} value={0.22} name={'a'}/>
                                    <label htmlFor={'radii-5'}>Low(L)</label>
                                </td>
                                <td>
                                    <input type='radio' id={'radii-6'} value={0.56} name={'a'}/>
                                    <label htmlFor={'radii-6'}>High(H)</label>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <br/>
                        <button onClick={() => this.kk()}>Подсчет результа</button>
                    </div>
                </div>
                <div className={"TemporalScore"}>
                    <br/>
                    <h3>Временная оценка: {TemporalScore}</h3>
                    <br/>
                    <button onClick={(event) => this.openClose(event)}><h2 className={"Temporal"}>Временные
                        метрики:</h2>
                    </button>
                    <br/>
                    <br/>
                    <br/>
                    <div id={"Temporal"}>
                        <label>Доступность средства эксплуатации(E):</label>
                        <table>
                            <tbody>
                            <tr className={'E'} id={'E'}>
                                <td>
                                    <input type='radio' id='radio-11' value={1.0} name={"e"}/>
                                    <label htmlFor={"radio-11"}>Не определено(X) </label>
                                </td>
                                <td>
                                    <input type='radio' id='radio-12' value={0.91} name={"e"}/>
                                    <label htmlFor={"radio-12"}>Теоретически(U) </label>
                                </td>
                                <td>
                                    <input type='radio' id='radio-13' value={0.94} name={"e"}/>
                                    <label htmlFor={"radio-13"}>Есть концепция(P)</label>
                                </td>
                                <td>
                                    <input type='radio' id='radio-14' value={0.97} name={"e"}/>
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
                                    <label htmlFor={"radio-16"}>Не определено(X) </label>
                                </td>
                                <td>
                                    <input type='radio' id='radio-17' value={0.95} name={"rl"}/>
                                    <label htmlFor={"radio-17"}>Официальное(O) </label>
                                </td>
                                <td>
                                    <input type='radio' id='radio-18' value={0.96} name={"rl"}/>
                                    <label htmlFor={"radio-18"}>Temporary fix(T)</label>
                                </td>
                                <td>
                                    <input type='radio' id='radio-19' value={0.97} name={"rl"}/>
                                    <label htmlFor={"radio-19"}>Workaround(W)</label>
                                </td>
                                <td>
                                    <input type='radio' id='radio-20' value={1.0} name={"rl"}/>
                                    <label htmlFor={"radio-20"}>Недоступно(U)</label>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <label>Степень доверенности источника(RC):</label>
                        <table>
                            <tbody>
                            <tr className={'RC'} id={'RC'}>
                                <td>
                                    <input type='radio' id='radio-21' value={1.0} name={"rc"}/>
                                    <label htmlFor={"radio-21"}>Не определено(X) </label>
                                </td>
                                <td>
                                    <input type='radio' id='radio-22' value={0.92} name={"rc"}/>
                                    <label htmlFor={"radio-22"}>Unknown(U) </label>
                                </td>
                                <td>
                                    <input type='radio' id='radio-23' value={0.96} name={"rc"}/>
                                    <label htmlFor={"radio-23"}>Reasonable(R)</label>
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
                </div>
                <br/>
                <div className={"EnvScore"}>
                    <h3> Контекстная оценка: {EnvScore}</h3>
                    <br/>
                    <button onClick={(event) => this.openClose(event)}><h2 className={"Environmental"}>Контекстные
                        метрики:</h2></button>
                    <br/>
                    <br/>
                    <br/>
                    <div id={"Environmental"}>
                        <label>Скорректированный вектор атаки(MAV):</label>
                        <table>
                            <tbody>
                            <tr className={'MAV'} id={'MAV'}>
                                <td>
                                    <input type='radio' id='radioi-11' value={this.state.AV} name={"mav"}/>
                                    <label htmlFor={"radioi-11"}>Not defined(X) </label>
                                </td>
                                <td>
                                    <input type='radio' id='radioi-12' value={0.85} name={"mav"}/>
                                    <label htmlFor={"radioi-12"}>Network(N) </label>
                                </td>
                                <td>
                                    <input type='radio' id='radioi-14' value={0.62} name={"mav"}/>
                                    <label htmlFor={"radioi-14"}>Adjacent network(A)</label>
                                </td>
                                <td>
                                    <input type='radio' id='radioi-13' value={0.55} name={"mav"}/>
                                    <label htmlFor={"radioi-13"}>Local(L)</label>
                                </td>
                                <td>
                                    <input type='radio' id='radioi-35' value={0.2} name={"mav"}/>
                                    <label htmlFor={"radioi-35"}>Physical(P)</label>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <label>Скорректированная сложность атаки(MAC):</label>
                        <table>
                            <tbody>
                            <tr className={'MAC'} id={'MAC'}>
                                <td>
                                    <input type='radio' id='radioi-16' value={this.state.AC} name={"ac"}/>
                                    <label htmlFor={"radioi-16"}>Not defined(X) </label>
                                </td>
                                <td>
                                    <input type='radio' id='radioi-17' value={0.77} name={"ac"}/>
                                    <label htmlFor={"radioi-17"}>Low(L) </label>
                                </td>
                                <td>
                                    <input type='radio' id='radioi-18' value={0.44} name={"ac"}/>
                                    <label htmlFor={"radioi-18"}>High(H)</label>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <label>Скорректированный уровень привилегий(MPR):</label>
                        <table>
                            <tbody>
                            <tr className={'MPR'} id={'MPR'}>
                                <td>
                                    <input type='radio' id='radiol-21' value={this.state.PR} name={"mpr"}/>
                                    <label htmlFor={"radiol-21"}>Not defined(X) </label>
                                </td>
                                <td>
                                    <input type='radio' id='radiol-22' value={0.85} name={"mpr"}/>
                                    <label htmlFor={"radiol-22"}>None(N)</label>
                                </td>
                                <td>
                                    <input type='radio' id='radiol-23' value={this.state.MS === 1 ? 0.68 : 0.62}
                                           name={"mpr"}/>
                                    <label htmlFor={"radiol-23"}>Low(L)</label>
                                </td>
                                <td>
                                    <input type='radio' id='radiol-24' value={this.state.MS === 1 ? 0.5 : 0.27}
                                           name={"mpr"}/>
                                    <label htmlFor={"radiol-24"}>High(H)</label>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <label>Скорректированное взаимодействие с пользователем(MUI):</label>
                        <table>
                            <tbody>
                            <tr className={'MUI'} id={'MUI'}>
                                <td>
                                    <input type='radio' id='radiok-21' value={this.state.UI} name={"mui"}/>
                                    <label htmlFor={"radiok-21"}>Not defined(X) </label>
                                </td>
                                <td>
                                    <input type='radio' id='radiok-22' value={0.85} name={"mui"}/>
                                    <label htmlFor={"radiok-22"}>None(N) </label>
                                </td>
                                <td>
                                    <input type='radio' id='radiok-23' value={0.62} name={"mui"}/>
                                    <label htmlFor={"radiok-23"}>Required(R)</label>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <label>Скорректированное влияние на другие компоненты системы(MS):</label>
                        <table>
                            <tbody>
                            <tr className={'MS'} id={'MS'}>
                                <td>
                                    <input type='radio' id='radiokl-21' value={this.state.S} name={"ms"}/>
                                    <label htmlFor={"radiokl-21"}>Not defined(X) </label>
                                </td>
                                <td>
                                    <input type='radio' id='radiokl-22' value={0} name={"ms"}/>
                                    <label htmlFor={"radiokl-22"}>Unchanged(U) </label>
                                </td>
                                <td>
                                    <input type='radio' id='radiokl-23' value={1.0} name={"ms"}/>
                                    <label htmlFor={"radiokl-23"}>Changed(C)</label>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <br/>
                        <label>Скорректированное влияние на конфиденциальность (MC):</label>
                        <table>
                            <tbody>
                            <tr className={'MC'} id={'MC'}>
                                <td>
                                    <input type='radio' id='radioklk-21' value={this.state.C} name={"mc"}/>
                                    <label htmlFor={"radioklk-21"}>Not defined(X) </label>
                                </td>
                                <td>
                                    <input type='radio' id='radioklk-22' value={0} name={"mc"}/>
                                    <label htmlFor={"radioklk-22"}>None(N) </label>
                                </td>
                                <td>
                                    <input type='radio' id='radioklk-23' value={0.22} name={"mc"}/>
                                    <label htmlFor={"radioklk-23"}>Low(L)</label>
                                </td>
                                <td>
                                    <input type='radio' id='radioklk-24' value={0.56} name={"mc"}/>
                                    <label htmlFor={"radioklk-24"}>High(H)</label>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <label> Скорректированное влияние на целостность(MI):</label>
                        <table>
                            <tbody>
                            <tr className={'MI'} id={'MI'}>
                                <td>
                                    <input type='radio' id='radioklk-25' value={this.state.I} name={"mi"}/>
                                    <label htmlFor={"radioklk-25"}>Not defined(X) </label>
                                </td>
                                <td>
                                    <input type='radio' id='radioklk-26' value={0} name={"mi"}/>
                                    <label htmlFor={"radioklk-26"}>None(N) </label>
                                </td>
                                <td>
                                    <input type='radio' id='radioklk-27' value={0.22} name={"mi"}/>
                                    <label htmlFor={"radioklk-27"}>Low(L)</label>
                                </td>
                                <td>
                                    <input type='radio' id='radioklk-28' value={0.56} name={"mi"}/>
                                    <label htmlFor={"radioklk-28"}>High(H)</label>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <label> Скорректированное влияние на доступность(MA):</label>
                        <table>
                            <tbody>
                            <tr className={'MA'} id={'MA'}>
                                <td>
                                    <input type='radio' id='radioklk-29' value={this.state.A} name={"ma"}/>
                                    <label htmlFor={"radioklk-29"}>Not defined(X) </label>
                                </td>
                                <td>
                                    <input type='radio' id='radioklk-30' value={0} name={"ma"}/>
                                    <label htmlFor={"radioklk-30"}>None(N) </label>
                                </td>
                                <td>
                                    <input type='radio' id='radioklk-31' value={0.22} name={"ma"}/>
                                    <label htmlFor={"radioklk-31"}>Low(L)</label>
                                </td>
                                <td>
                                    <input type='radio' id='radioklk-32' value={0.56} name={"ma"}/>
                                    <label htmlFor={"radioklk-32"}>High(H)</label>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <label>Требования к конфиденциальности(CR):</label>
                        <table>
                            <tbody>
                            <tr className={'CR'} id={'CR'}>
                                <td>
                                    <input type='radio' id='radiole-21' value={1.0} name={"cr"}/>
                                    <label htmlFor={"radiole-21"}>Не определено(X) </label>
                                </td>
                                <td>
                                    <input type='radio' id='radiole-22' value={1.5} name={"cr"}/>
                                    <label htmlFor={"radiole-22"}>High(H) </label>
                                </td>
                                <td>
                                    <input type='radio' id='radiole-23' value={1.0} name={"cr"}/>
                                    <label htmlFor={"radiole-23"}>Средняя(M)</label>
                                </td>
                                <td>
                                    <input type='radio' id='radiole-24' value={0.5} name={"cr"}/>
                                    <label htmlFor={"radiole-24"}>Low(L)</label>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <label>Требования к целостности(IR):</label>
                        <table>
                            <tbody>
                            <tr className={'IR'} id={'IR'}>
                                <td>
                                    <input type='radio' id='radiole-211' value={1.0} name={"ir"}/>
                                    <label htmlFor={"radiole-211"}>Не определено(X) </label>
                                </td>
                                <td>
                                    <input type='radio' id='radiole-222' value={1.5} name={"ir"}/>
                                    <label htmlFor={"radiole-222"}>High(H) </label>
                                </td>
                                <td>
                                    <input type='radio' id='radiole-233' value={1.0} name={"ir"}/>
                                    <label htmlFor={"radiole-233"}>Средняя(M)</label>
                                </td>
                                <td>
                                    <input type='radio' id='radiole-244' value={0.5} name={"ir"}/>
                                    <label htmlFor={"radiole-244"}>Low(L)</label>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <label>Требования к доступности(AR):</label>
                        <table>
                            <tbody>
                            <tr className={'AR'} id={'AR'}>
                                <td>
                                    <input type='radio' id='radiole-121' value={1.0} name={"ar"}/>
                                    <label htmlFor={"radiole-121"}>Не определено(X) </label>
                                </td>
                                <td>
                                    <input type='radio' id='radiole-122' value={1.5} name={"ar"}/>
                                    <label htmlFor={"radiole-122"}>High(H) </label>
                                </td>
                                <td>
                                    <input type='radio' id='radiole-123' value={1.0} name={"ar"}/>
                                    <label htmlFor={"radiole-123"}>Medium(M)</label>
                                </td>
                                <td>
                                    <input type='radio' id='radiole-124' value={0.5} name={"ar"}/>
                                    <label htmlFor={"radiole-124"}>Low(L)</label>
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
                </div>
            </div>);
    }
}

export default v3;

