# FirstAndLast TM program
# For a given input string on the alphabet {0,1}*, returns the
# first character followed by last one.

# Get first char
q0]r (#/#, q-1)  # If nothing on input, return
q0]r (1/1, q1)   # Check whether 1, 0 or #
q0]r (0/0, q3)
q1]r (1/1, q1)   # Traverse till end of tape
q1]r (0/0, q1)
q1]r (#/#, q2)
q2]r (#/1, q5)   # Add one to end of tape
q3]r (1/1, q3)   # Traverse till end of tape
q3]r (0/0, q3)
q3]r (#/#, q4)
q4]r (#/0, q5)   # Add zero to end of tape
q5]l (#/#, q6)   # Checkpoint at middle blank

# Get last char
q6]l (1/1, q7)
q6]l (0/0, q10)
q7]r (#/#, q8)
q8]r (1/1, q9)
q8]r (0/0, q9)
q9]r (#/1, q13)
q10]r (#/#, q11)
q11]r (1/1, q12)
q12]r (#/1, q13)
q13]l (1/1, q13)
q13]l (0/0, q13)
q13]l (#/#, q-1) # End
 