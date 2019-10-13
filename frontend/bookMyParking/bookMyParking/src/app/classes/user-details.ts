export class UserDetails {
    public userId: number;
	public city: string;
	public contactNo: string;
	public email: string;
	public password: string;
	public userName: string;
	public walletBalance: number;
    public isLoggedIn: boolean;
    constructor(userId?: number,
        city?: string,
        contactNo?: string,
        email?: string,
        password?: string,
        userName?: string,
        walletBalance?: number,
        isLoggedIn?: boolean){
            this.userId = userId;
            this.city = city;
            this.contactNo = contactNo;
            this.email = email;
            this.password = password;
            this.userName = userName;
            this.walletBalance = walletBalance;
            this.isLoggedIn = isLoggedIn;
    }
    
}
