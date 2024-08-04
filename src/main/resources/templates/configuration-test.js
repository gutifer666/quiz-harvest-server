document.getElementById('testForm').addEventListener('submit', function(event) {
    const percentageOfQuestions = document.getElementById('percentageOfQuestions').value;

    if (percentageOfQuestions < 1 || percentageOfQuestions > 100) {
        alert('Percentage of Questions must be between 1 and 100');
        event.preventDefault();
    }
});
