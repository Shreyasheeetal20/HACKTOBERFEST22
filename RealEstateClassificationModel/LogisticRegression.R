# Maximum likelihood method is used to estimate the variables

#########################################################
# Logistic Regression with single predictor

#glm.fit = glm(Sold~price, data = df,family = binomial)
#summary(glm.fit)
#########################################################

# Logistic Regression with Multipal Predictor

glm.fit = glm(Sold~., data = df,family = binomial)
summary(glm.fit)

glm.probs = predict(glm.fit,type = "response") # predicting problity of the model on the data
glm.probs[1:10]

# using boundry condition we can classify the class according to the threshold probablity

glm.pred = rep("No",506) # creating an array which consist of 506 "No values"
# Now wherever the probablity is > 0.5 will change the "No" to "Yes" 
glm.pred[glm.probs>0.5] = "Yes"

#Confusion Matrix
table(glm.pred,df$Sold)

