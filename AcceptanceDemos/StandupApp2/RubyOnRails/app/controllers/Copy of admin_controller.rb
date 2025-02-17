class AdminController < ApplicationController
  def index
    list
    render :action => 'list'
  end

  # GETs should be safe (see http://www.w3.org/2001/tag/doc/whenToUseGet.html)
  verify :method => :post, :only => [ :destroy, :create, :update ],
         :redirect_to => { :action => :list }

  def list
    @conference_pages, @conferences = paginate :conferences, :per_page => 10
  end

  def show
    @conference = Conference.find(params[:id])
  end

  def new
    @conference = Conference.new
  end

  def create
    @conference = Conference.new(params[:conference])
    if @conference.save
      flash[:notice] = 'Conference was successfully created.'
      redirect_to :action => 'list'
    else
      render :action => 'new'
    end
  end

  def edit
  puts "edit"
    @conference = Conference.find(params[:id])
	@all_participants = Participant.find(:all)
    @selected_participants = @conference.participants
    @unselected_participants = []
	for participant in @all_participants
	  if ! @selected_participants.include?(participant)
		@unselected_participants << participant 
	  end
	end
  end
  
  def participant_selected
    puts "participant: " + params[:partid]
    puts "conference: " + params[:id]
    @conference = Conference.find(params[:id])
	@participant = Participant.find(params[:partid])
	@conference.participants << @participant

	@all_participants = Participant.find(:all)
    @selected_participants = @conference.participants
    @unselected_participants = []
	for participant in @all_participants
	  if ! @selected_participants.include?(participant)
		@unselected_participants << participant 
	  end
	end
	render :partial => 'participants_table'
    #redirect_to :action => 'edit', :id => params[:id]
  end

  def participant_unselected
    puts "participant: " + params[:partid]
    puts "conference: " + params[:id]
    @conference = Conference.find(params[:id])
	@participant = Participant.find(params[:partid])
	@conference.participants.delete(@participant)

	@all_participants = Participant.find(:all)
    @selected_participants = @conference.participants
    @unselected_participants = []
	for participant in @all_participants
	  if ! @selected_participants.include?(participant)
		@unselected_participants << participant 
	  end
	end
	render :partial => 'participants_table'
#    redirect_to :action => 'edit', :id => params[:id]
  end

  def update
    @conference = Conference.find(params[:id])
    if @conference.update_attributes(params[:conference])
      flash[:notice] = 'Conference was successfully updated.'
      redirect_to :action => 'show', :id => @conference
    else
      render :action => 'edit'
    end
  end

  def destroy
    Conference.find(params[:id]).destroy
    redirect_to :action => 'list'
  end
end
