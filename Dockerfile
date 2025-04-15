FROM maven:3.9.6-eclipse-temurin-17

# Set workdir
WORKDIR /usr/src/app

# Copy everything
COPY . .

# Build tests
RUN mvn clean compile

# Run tests
CMD ["mvn", "test"]
