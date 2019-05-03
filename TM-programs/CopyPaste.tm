# CopyPaste TM program
# Returns an input on {1,0}* replicated.

q0]r (1/X, q1) (0/Y, q2) (#, q-1)
q1]r (#/N, q6)
q2]r (#/M, q6)
q3]r (1/X, q4) (0/Y, q5) (N/1, q7) (M/0, q7)
q4]r (#/1, q6)
q5]r (#/0, q6)
q6]l (X/1, q3) (Y/0, q3) 
q7]l (#, q-1)