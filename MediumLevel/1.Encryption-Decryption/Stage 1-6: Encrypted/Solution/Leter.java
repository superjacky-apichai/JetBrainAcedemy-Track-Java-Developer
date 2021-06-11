package encryptdecrypt;

enum Letter {
    a(122,'a'), b(121,'b'), c(120,'c'), d(119,'d')
    , e(118,'e'), f(117,'f'), g(116,'g'), h(115,'h')
    , i(114,'i'), j(113,'j'), k(112,'k'), l(111,'l')
    , m(110,'m'), n(109,'n'), o(108,'o'), p(107,'p')
    , q(106,'q'), r(105,'r'), s(104,'s'), t(103,'t')
    , u(102,'u'), v(101,'v'), w(100,'w'), x(99,'x')
    , y(98,'y'), z(97,'z') ;


    Letter(int charNumber, char getChar) {

        this.charNumber = charNumber;
        this.getChar = getChar;
    }

    char getChar;
    int charNumber;
    

}
