@Programa Fonte Unifor
fita 101011
init q0
accept qf

q0,1,q0,1,>
q0,0,q0,0,>
q0,_,q1,c,<

q1,1,q1,1,<
q1,0,q1,0,<
q1,_,q2,_,>


q2,1,q4,x,>
q2,0,q3,y,>
q2,c,q5,c,<


q3,1,q3,1,>
q3,0,q3,0,>
q3,c,q3,c,>
q3,_,q6,0,<


q4,1,q4,1,>
q4,0,q4,0,>
q4,c,q4,c,>
q4,_,q6,1,<


q5,1,q5,1,<
q5,0,q5,0,<
q5,_,q7,_,>


q6,1,q6,1,<
q6,0,q6,0,<
q6,c,q6,c,<
q6,y,q2,0,>
q6,x,q2,1,>

q7,1,q7,1,>
q7,0,q7,0,>
q7,c,qii,c,>


qii,1,qii,1,<
qii,0,qii,0,<
qii,c,qt,c,>

qt,0,q00,c,<
qt,1,q10,c,<
qt,_,qt,_,<
qt,c,qreb,_,<

q00,0,q00,0,>
q00,1,q00,1,>
q00,c,qii,0,>

q10,0,q10,0,>
q10,1,q10,1,>
q10,c,qii,1,>


qreb,0,qreb,0,<
qreb,1,qreb,1,<
qreb,_,qf,_,>