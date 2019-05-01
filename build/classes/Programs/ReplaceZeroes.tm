# ReplaceZeroes TM program
# For a given string on {0,1}*, replaces all zero characters by ones.

q0]r(0/1,q0)
q0]r(1/1,q0)
q0]r(#/#,q1)
q1]l(1/1,q1)
q1]l(0/0,q1)
q1]l(#/#,q-1)