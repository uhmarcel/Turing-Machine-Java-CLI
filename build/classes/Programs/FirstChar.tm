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
q5]l (#/#, q-1)  
