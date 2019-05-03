# Reverse TM program
# Reverses the input string on {0,1}*, uses short notation.

q0]r (#, q1)
q1]l (1/X, q2) (0/Y, q4) (#, q7)
q2]r (#, q3)
q3]r (#/1, q6)
q4]r (#, q5)
q5]r (#/0, q6)
q6]l (X/1, q1) (Y/0, q1)
q7]r (#, q-1)