export class Register {
    id: number
    registerUsername: string
    registerEmail: string
    registerPassword: string
    registerPasswordRetype: string

    constructor() {
        this.registerUsername = ''
        this.registerEmail = ''
        this.registerPassword = ''
        this.registerPasswordRetype = ''
    }
}
