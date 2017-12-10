package uit.dev.demomvp.Model

/**
 * Created by Administrator on 09/12/2017.
 */

class User {

    var email: String? = null
    var password: String? = null

    constructor(email: String, password: String) {
        this.email = email
        this.password = password
    }

    constructor() {

    }
}
